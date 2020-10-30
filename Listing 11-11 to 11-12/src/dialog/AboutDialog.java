package dialog;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner){
        super(owner, "Test okna O programie", true);
        //dodanie etykiety HTML
        add(new JLabel("<html><h1><i>Core Java</i></h1><hr>By Darek</html>"),
                BorderLayout.CENTER);

        //przycisk OK zamyka okno
        var ok = new JButton("OK");
        ok.addActionListener(e -> setVisible(false));

        //dodanie przycisku ok przy krawędzi południowej
        var panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }
}
