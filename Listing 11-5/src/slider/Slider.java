package slider;

import javax.swing.*;
import java.awt.*;

public class Slider {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new SliderFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Sliders");
            frame.setVisible(true);
        });
    }
}
