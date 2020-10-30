package notHelloWorld;


import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new NotHelloWorldFrame();
            frame.setTitle("Not Hello World");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldPanel());
        pack();
    }
}

class NotHelloWorldPanel extends JComponent {
    public static final int MESSEGE_X = 75;
    public static final int MESSEGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("To nie jest program \"Witaj świecie\".", MESSEGE_X, MESSEGE_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
