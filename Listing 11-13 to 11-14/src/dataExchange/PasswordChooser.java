package dataExchange;

import javax.swing.*;
import java.awt.*;

//elementy służące do podania hasła, które widać w oknie dialogowym
public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser(){
        setLayout(new BorderLayout());

        //utworzenie panelu z polami nazwy użytkownika i hasła
        var panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("Nazwa użytkownika: "));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Hasło: "));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        //utworzenie przycisków OK i Anuluj, które zamykają okna dialogowe
        okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            ok = true;
            dialog.setVisible(false);
        });

        var cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(e -> dialog.setVisible(false));

        //dodawanie przycisków w pobliżu południowej krawędzi
        var buttonPanel = new  JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //ustawia wartości domyślne okna dialogowego
    public void setUser(User u){
        username.setText(u.getName());
    }

    //pobiera dane podane w oknie dialogowym
    public User getUser(){
        return new User(username.getText(), password.getPassword());
    }

    //wyświetla panel z elementami przyjmującymi dane od użytkownika w oknie dialogowym
    public boolean showDialog(Component parent, String title){
        ok = false;
        //lokalizacja ramki nadrzędnej
        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        //jeśli jest to pierwszy raz lub zmienił się użytkownik, utworzenie nowego okna dialogowego
        if (dialog == null || dialog.getOwner() != owner){
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        //ustawienie tytułu i wyświetlenie okna dialogowego
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
