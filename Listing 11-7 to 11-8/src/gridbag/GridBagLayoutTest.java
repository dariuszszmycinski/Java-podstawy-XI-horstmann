package gridbag;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new FontFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Font");
            frame.setVisible(true);
        });
    }
}
