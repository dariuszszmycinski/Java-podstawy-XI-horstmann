package comboBox;

import javax.swing.*;
import java.awt.*;

//ramka z przykładową etykietą tekstową i listą rozwijaną umożliwiającą wybór kroju czcionki
public class ComboBoxFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {
        //dodanie tekstu etykiety
        label = new JLabel("Wściekłe pięści węża.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //tworzenie listy rozwijanej i dodawanie nazw czcionek
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //nasłuchiwacz listy rozwijanej zmienia krój pisma etykiety na czcionkę wybraną przez użytkownika
        faceCombo.addActionListener(e ->
                label.setFont(
                        new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                                Font.PLAIN,DEFAULT_SIZE)));

        //dodanie listy rozwijanej do panelu dolnego
        var comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }
}
