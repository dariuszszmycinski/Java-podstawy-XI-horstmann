package circleLayout;

import javax.swing.*;
import java.awt.*;

public class CircleLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new CircleLayoutFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Circle layout");
            frame.setVisible(true);
        });
    }
}
