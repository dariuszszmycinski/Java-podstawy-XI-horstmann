package text;

import javax.swing.*;
import java.awt.*;

public class TextComponent {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new TextComponentFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Text component");
            frame.setVisible(true);
        });
    }
}
