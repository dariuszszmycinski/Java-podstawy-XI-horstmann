package menu;

import javax.swing.*;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new MenuFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Menu");
            frame.setVisible(true);
        });
    }
}
