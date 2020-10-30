package circleLayout;

import javax.swing.*;

//ramka zawierająca przyciski ułożone na obwodzie okręgu
public class CircleLayoutFrame extends JFrame {
    public CircleLayoutFrame(){
        setLayout(new CircleLayout());
        add(new JButton("Zółty"));
        add(new JButton("Niebieski"));
        add(new JButton("Czerwony"));
        add(new JButton("Zielony"));
        add(new JButton("Pomarańczowy"));
        add(new JButton("Fuksja"));
        add(new JButton("Błękit"));
        pack();
    }
}
