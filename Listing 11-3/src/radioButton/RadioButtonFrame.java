package radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//ramka z przykładową etykietą tekstową i przełącznikami służącymi do wyboru rozmiaru czcionki
public class RadioButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private  ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame(){
        //dodanie przykładowej etykiety tekstowej
        label = new JLabel("Wschodni wiatr spienione goni fale.");
        label.setFont(new Font("Seriff", Font.PLAIN ,DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //dodanie przełączników
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        addRadioButton("Mała", 8);
        addRadioButton("Średnia",12);
        addRadioButton("Duża",18);
        addRadioButton("Bardzo Duża",36);
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    //tworzy przełącznik ustawiający rozmiar czcionki przykładowego pliku
    public void addRadioButton(String name, int size){
        boolean selected = size == DEFAULT_SIZE;
        var button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        //ten nasłuchiwacz ustawia rozmiar czcionki
        ActionListener listener = e -> label.setFont(new Font("Seriff", Font.PLAIN,size));
        button.addActionListener(listener);
    }
}
