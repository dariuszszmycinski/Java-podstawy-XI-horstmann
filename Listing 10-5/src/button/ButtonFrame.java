package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//kalsa z panelem zawierającym przyciski
public class ButtonFrame extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new ButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //tworzenie przycisków
        var yellowButton = new JButton("Żółty");
        var blueButton = new JButton("Niebieski");
        var redButton = new JButton("Czerwony");
        buttonPanel = new JPanel();

        //dodanie przycisków do panelu
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //dodanie panelu do ramki
        add(buttonPanel);

        //utworzenie akcji przycisków
        var yellowAction = new ColorAction(Color.YELLOW);
        var blueAction = new ColorAction(Color.BLUE);
        var redAction = new ColorAction(Color.RED);

        //powiązanie akcji z przyciskami
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

    }

    private class ColorAction implements ActionListener{
        private Color backgroundColor;

        public ColorAction(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }

}
