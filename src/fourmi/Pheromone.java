package fourmi;

import java.awt.*;

/**
 * Created by scabiati on 07/07/2017.
*/

public class Pheromone extends Element{

    private int vie;
    private int transparence;
    private int incrementationTransparence;
    private int evaporation;
    private int nbTours;

    public Pheromone(int x, int y, int vie){
        super(x,y,new Color(0,125,125,254));
        this.vie = 10;
        this.transparence = 254;
        this.incrementationTransparence = 25;
        this.evaporation = 500;
        this.nbTours = 0;
    }

    public int getIncrementationTransparence() {
        return incrementationTransparence;
    }

    public int getVie() {

        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }


    public int getTransparence() {
        return transparence;
    }

    public void setTransparence(int transparence) {
        this.transparence = transparence;
    }



    public int getEvaporation() {
        return evaporation;
    }

    public void setEvaporation(int evaporation) {
        this.evaporation = evaporation;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }
}


