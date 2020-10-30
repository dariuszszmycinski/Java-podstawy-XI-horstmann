package checkBox;

import javax.swing.*;
import java.awt.*;

public class CheckBox {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new CheckBoxFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Check box");
            frame.setVisible(true);
        });
    }
}
