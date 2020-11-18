package swingWorker;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

//program demonstrujący wątek roboczy wykonujący potencjalnie pracochłonne zadanie
public class SwingWorkerTest {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            var frame = new SwingWorkerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

//ramka mająca obszar tekstowy pokazujący zawartość pliku tekstowego, menu pozwalające otworzyć plik i anulować proces otwierania pliku oraz wiersz stanu pokazujący postęp ładowania pliku
class SwingWorkerFrame extends JFrame {
    private JFileChooser chooser;
    private JTextArea textArea;
    private JLabel statusLine;
    private JMenuItem openItem;
    private JMenuItem cancelItem;
    private SwingWorker<StringBuilder, ProgressData> textReader;
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 60;

    public SwingWorkerFrame() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea));

        statusLine = new JLabel(" ");
        add(statusLine, BorderLayout.SOUTH);

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("Plik");
        menuBar.add(menu);

        openItem = new JMenuItem("Otwórz");
        menuBar.add(openItem);
        openItem.addActionListener(e -> {
            //wyświetlenie okna dialogowego wyboru pliku
            int result = chooser.showOpenDialog(null);

            //jeśli plik został wybrany, zostanie on ustawiony jako ikona etykiety
            if (result == JFileChooser.APPROVE_OPTION) {
                textArea.setText("");
                openItem.setEnabled(false);
                textReader = new TextReader(chooser.getSelectedFile());
                textReader.execute();
                cancelItem.setEnabled(true);
            }
        });

        cancelItem = new JMenuItem("Anuluj");
        menu.add(cancelItem);
        cancelItem.setEnabled(false);
        cancelItem.addActionListener(e -> textReader.cancel(true));
        pack();
    }

    private class ProgressData {
        private int number;
        private String line;
    }

    private class TextReader extends SwingWorker<StringBuilder, ProgressData> {
        private File file;
        private StringBuilder text = new StringBuilder();

        public TextReader(File file) {
            this.file = file;
        }

        //poniższa metoda jest wykonywana w wątku roboczym, nie operuje na komponentach Swing
        @Override
        protected StringBuilder doInBackground() throws IOException, InterruptedException {
            int lineNumber = 0;
            try (var in = new Scanner(new FileInputStream(file), StandardCharsets.UTF_8)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    lineNumber++;
                    text.append(line).append("\n");
                    var data = new ProgressData();
                    data.number = lineNumber;
                    data.line = line;
                    publish(data);
                    Thread.sleep(1); //test operacji anulowania, nie ma potrzeby robienia
                }
            }
            return text;
        }

        //poniższe metody są wykonywane w wątku dystrybucji zdarzeń
        public void process(List<ProgressData> data) {
            if (isCancelled()) return;
            var builder = new StringBuilder();
            statusLine.setText("" + data.get(data.size() - 1).number);
            for (ProgressData d : data) builder.append(d.line).append("\n");
            textArea.append(builder.toString());
        }

        public void done() {
            try {
                StringBuilder result = get();
                textArea.setText(result.toString());
                statusLine.setText("Done");
            } catch (InterruptedException ex) {
            } catch (CancellationException ex) {
                textArea.setText("");
                statusLine.setText("Anulowano");
            } catch (ExecutionException ex) {
                statusLine.setText("" + ex.getCause());
            }

            cancelItem.setEnabled(false);
            openItem.setEnabled(true);
        }
    };
}