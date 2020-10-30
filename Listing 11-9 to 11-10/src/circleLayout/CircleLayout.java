package circleLayout;

import java.awt.*;

//ramka zawierająca komponenty ułożone w kółko
public class CircleLayout implements LayoutManager {
    private int minWidth = 0;
    private int minHeight = 0;
    private int preferredWidth = 0;
    private int prefferedHeight = 0;
    private boolean sizeSet = false;
    private int maxComponentWidth = 0;
    private int maxComponentHeight = 0;

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    public void setSizes(Container parent) {
        if (sizeSet) return;
        int n = parent.getComponentCount();

        preferredWidth = 0;
        prefferedHeight = 0;
        minWidth = 0;
        minHeight = 0;
        maxComponentWidth = 0;
        maxComponentHeight = 0;

        //obliczanie maksymalnych szerokości komponentów oraz ustawianie preferowanego rozmiaru na sumę rozmiarów komponentów
        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);
            if (c.isVisible()) {
                Dimension d = c.getPreferredSize();
                maxComponentWidth = Math.max(maxComponentWidth, d.width);
                maxComponentHeight = Math.max(maxComponentHeight, d.height);
                preferredWidth += d.width;
                prefferedHeight += d.height;
            }
        }
        minWidth = preferredWidth / 2;
        minHeight = prefferedHeight / 2;
        sizeSet = true;
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int width = preferredWidth + insets.left + insets.right;
        int height = prefferedHeight + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int width = preferredWidth + insets.left + insets.right;
        int height = prefferedHeight + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    @Override
    public void layoutContainer(Container parent) {
        setSizes(parent);
        //obliczanie środka okręgu
        Insets insets = parent.getInsets();
        int containerWidth = parent.getSize().width - insets.left - insets.right;
        int containerHeight = parent.getSize().height - insets.top - insets.bottom;
        int xcenter = insets.left + containerWidth / 2;
        int ycenter = insets.top + containerHeight / 2;

        //obliczanie promienia okręgu
        int xradius = (containerWidth - maxComponentWidth)/2;
        int yradius = (containerHeight - maxComponentHeight)/2;
        int radius = Math.min(xradius, yradius);

        //układanie komponentów na okręgu
        int n = parent.getComponentCount();
        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);
            if (c.isVisible()){
                double angle = 2* Math.PI * i/n;
                //środek komponentu
                int x = xcenter + (int) (Math.cos(angle) * radius);
                int y = ycenter + (int) (Math.sin(angle) * radius);
                //przesunięcie komponentu aby środek znajdował się w xy a jego rozmiar był rozmiarem preferowanym
                Dimension d = c.getPreferredSize();
                c.setBounds(x - d.width/2, y-d.height/2, d.width, d.height);
            }
        }
    }
}
