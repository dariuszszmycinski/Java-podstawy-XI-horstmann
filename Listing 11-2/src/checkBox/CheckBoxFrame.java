package checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//ramka z przykładową etkietą takstową i polami wyboru reprezentującymi różne atrybuty czcionki
public class CheckBoxFrame extends JFrame {
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame(){
        label = new JLabel("Koń i żółw grali w kości z piękną ćmą u źródła.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        //nasłuchiwacz ustawiający atrybuty czcionki
        ActionListener listener = e -> {
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        //dodanie pól wyboru
        var buttonPanel = new JPanel();
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
