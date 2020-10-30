package gridbag;

import java.awt.*;

//klasa upraszcza korzystanie z klasy GridBagConstrains
public class GBC extends GridBagConstraints {
    //tworzy obiekt typu GBCz podanymi wartościami gridx i gridy oraz wszystkimi pozostałymi parametrami ustawionymi na wartości domyślne

    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    //tworzy obiekt typu GBC z podanymi wartościami gridx, gridy, gridwidth i gridheight oraz wszystkimi pozostałymi parametrami ustawionymi na wartości domyślne

    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    //ustawia parametr anchor
    public GBC setAnchor(int anchor){
        this.anchor = anchor;
        return this;
    }

    //ustawia kierunek zapełniania
    public GBC setFill(int fill){
        this.fill = fill;
        return this;
    }

    //ustawia parametry weight komórek
    public GBC setWeight(double weightx, double weighty){
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    //ustawia dodatkową pustą przestrzeń w komórce
    public GBC setInsets(int distance){
        this.insets = new Insets(distance,distance,distance,distance);
        return this;
    }

    //ustawia dopełnienia w komórce
    public GBC setInsets(int top, int left, int bottom, int right){
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    //ustawia dopełnienie wewnętrzne
    public GBC setIpad (int ipadx, int ipady){
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }


}
