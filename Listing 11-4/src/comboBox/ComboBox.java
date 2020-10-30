package comboBox;

import javax.swing.*;
import java.awt.*;

public class ComboBox {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new ComboBoxFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Combo box");
            frame.setVisible(true);
        });
    }
}
