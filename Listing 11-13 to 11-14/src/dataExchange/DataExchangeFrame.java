package dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ramka z menu, którego akcja plik/połącz wyświetla okno dialogowe z polem hasła
public class DataExchangeFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        //tworzenie menu plik
        var mbar = new JMenuBar();
        setJMenuBar(mbar);
        var fileMenu = new JMenu("Plik");
        mbar.add(fileMenu);

        //tworzenie elementów menu połącz i zamknij
        var connectItem = new JMenuItem("Połącz");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        //opcja zamknij zamyka program
        var exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    //akcja connect wyświetla okno dialogowe z polem hasła
    private class ConnectAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (dialog == null) dialog = new PasswordChooser();

            //ustawianie wartości domyślnych
            dialog.setUser(new User("Twoja nazwa", null));

            //wyświetlenie okna dialogowego
            if (dialog.showDialog(DataExchangeFrame.this, "Połącz")){
                //pobranie danych od użytkownika w przypadku zatwierdzenie
                User u = dialog.getUser();
                textArea.append("nazwa użytkownika = "+ u.getName()+", hasło = "+(new String(u.getPassword()))+"\n");
            }
        }
    }
}
