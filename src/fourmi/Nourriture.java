package fourmi;

import java.awt.*;
import java.util.Random;


public class Nourriture extends Element{

    private int vie;

    public Nourriture(int x, int y){
        super(x, y, Color.BLUE);
        Random rand = new Random();
        this.vie = rand.nextInt(5) + 1;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public Point getPos(){
        return new Point(this.getPosX(), this.getPosY());
    }
}
