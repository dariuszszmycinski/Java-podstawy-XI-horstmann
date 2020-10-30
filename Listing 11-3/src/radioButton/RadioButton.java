package radioButton;

import javax.swing.*;
import java.awt.*;

public class RadioButton {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new RadioButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
