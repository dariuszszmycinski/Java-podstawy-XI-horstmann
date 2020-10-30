package mouse;

import javax.swing.*;

/**
 * Ramka zawierająca okienko do testowania myszy
 */
public class MouseFrame extends JFrame
{
    public MouseFrame()
    {
        add(new MouseComponent());
        pack();
    }
}