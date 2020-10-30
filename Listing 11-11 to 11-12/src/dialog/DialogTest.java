package dialog;

import javax.swing.*;
import java.awt.*;

public class DialogTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new DialogFrame();
            frame.setTitle("Dialog test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
