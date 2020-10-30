package simpleFrame;

import java.awt.*;
import javax.swing.*;

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public SimpleFrame()  {
        setSize(WIDTH,HEIGHT);
    }
}
