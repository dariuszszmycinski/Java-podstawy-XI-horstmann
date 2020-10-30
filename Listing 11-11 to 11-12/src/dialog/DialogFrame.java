package dialog;

import javax.swing.*;

public class DialogFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //tworzenie menu Plik
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        var fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        //tworzenie elementów O programie i zamknij
        //element o programie wyświetla okno dialogowe o programie
        var aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(e -> {
            if (dialog == null) //pierwszy raz
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        //element zamknij powoduje zamknięcie programu
        var exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
    }
}
