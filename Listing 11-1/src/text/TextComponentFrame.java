package text;

import javax.swing.*;
import java.awt.*;

//ramka z przykładowymi komponentami tekstowymi
public class TextComponentFrame extends JFrame {
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    public TextComponentFrame(){
        var textField = new JTextField();
        var passwordField = new JPasswordField();
        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("Nazwa użytkownika: ",SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Hasło: ",SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        var textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        var scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        //dodanie przycisku wstawiającego tekst do obszaru tekstowego
        var southPanel = new JPanel();
        var insertButton = new JButton("Wstaw");
        southPanel.add(insertButton);
        insertButton.addActionListener(e ->{
                    textArea.append("Nazwa użytkownika: "+textField.getText()+" Hasło: "+
                            new String(passwordField.getPassword())+"\n");
                    textField.setText("");
                    passwordField.setText("");
                });
        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
}
