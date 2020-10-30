package timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        var timer = new Timer(1000,listener);
        timer.start();

        JOptionPane.showMessageDialog(null,"Zamknąć program?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Kiedy usłyszysz dźwięk, będzie godzina "+ Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}