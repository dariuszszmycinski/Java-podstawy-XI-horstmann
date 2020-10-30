package preferences;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.prefs.Preferences;

//program zapamiętuje położenie i rozmiar ramki oraz ostatnio otwarty plik
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

//przeglądarka plików, która przywraca ustawienia pozycji, rozmiaru i obrazu
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private String image;

    public ImageViewerFrame() {
        Preferences root = Preferences.userRoot();
        Preferences node = root.node("/com/horstmann/corejava/ImageViewer");
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);
        setBounds(left, top, width, height);
        image = node.get("image", null);
        var label = new JLabel();
        if (image != null) label.setIcon(new ImageIcon(image));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                node.putInt("left", getX());
                node.putInt("top", getY());
                node.putInt("width", getWidth());
                node.putInt("height", getWidth());
                node.put("image", image);
            }
        });

        //użycie etykiety do wyświetlania obrazu
        add(label);

        //element wyboru pliku
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        //pasek menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("Plik");
        menuBar.add(menu);

        var openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            //wyświetla okno dialogowe wyboru pliku
            int result = chooser.showOpenDialog(null);

            //jeśli plik zostanie wybrany, ustawia go jako ikonę etykiety
            if (result == JFileChooser.APPROVE_OPTION) {
                image = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(image));
            }
        });

        var exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));

    }
}
