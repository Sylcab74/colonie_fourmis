package fourmi;

import java.awt.*;


public class Fourmiliere extends Element {

    int vie;

    public Fourmiliere(int x, int y){
        super(x,y, new Color(130, 51, 0));
        this.vie = 0;
    }

    public int getVie() {
        return vie;
    }
}
