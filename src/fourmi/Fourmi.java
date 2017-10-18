package fourmi;

import java.awt.*;
import java.util.Random;



public class Fourmi extends Element {

    private boolean detectNourriture;
    private boolean nourritureTransporte;
    private Nourriture nourritureVue;
    private boolean suitPheromone;
    private Pheromone pheromoneCourrante;
    private Pheromone pheromonePrecedente;
    private int precedenteDirection;

    public boolean isDetectNourriture() {
        return detectNourriture;
    }

    public void setDetectNourriture(boolean detectNourriture) {
        this.detectNourriture = detectNourriture;
    }

    public boolean isNourritureTransporte() {
        return nourritureTransporte;
    }

    public void setNourritureTransporte(boolean nourritureTransporte) {
        this.nourritureTransporte = nourritureTransporte;
    }

    public Nourriture getNourritureVue() {
        return nourritureVue;
    }

    public void setNourritureVue(Nourriture nourritureVue) {
        this.nourritureVue = nourritureVue;
    }

    public boolean isSuitPheromone() {
        return suitPheromone;
    }

    public void setSuitPheromone(boolean suitPheromone) {
        this.suitPheromone = suitPheromone;
    }

    public Pheromone getPheromoneCourrante() {
        return pheromoneCourrante;
    }

    public void setPheromoneCourrante(Pheromone pheromoneCourrante) {
        this.pheromoneCourrante = pheromoneCourrante;
    }

    public Pheromone getPheromonePrecedente() {
        return pheromonePrecedente;
    }

    public void setPheromonePrecedente(Pheromone pheromonePrecedente) {
        this.pheromonePrecedente = pheromonePrecedente;
    }

    public Fourmi(int x, int y){
        super(x,y, Color.BLACK);
    }

    public void deplacementAleatoire(){
        Random rand = new Random();
        int i = rand.nextInt(8)+1;

        int j = rand.nextInt(100);
        if(j<80){
            i = this.precedenteDirection;
        }

        switch (i)
        {
            case 1:
                if(this.getPosX() < 637) {
                    this.setPosX(this.getPosX() + 1);
                }
                break;
            case 2:
                if((this.getPosX() < 637) && (this.getPosY() < 637)) {
                    this.setPosX(this.getPosX() + 1);
                    this.setPosY(this.getPosY() + 1);
                }
                break;
            case 3:
                if((this.getPosX() < 637) && (this.getPosY() > 3)) {
                    this.setPosX(this.getPosX() + 1);
                    this.setPosY(this.getPosY() - 1);
                }
                break;
            case 4:
                if((this.getPosX() > 3) && (this.getPosY() < 637)) {
                    this.setPosX(this.getPosX() - 1);
                    this.setPosY(this.getPosY() + 1);
                }
                break;
            case 5:
                if((this.getPosX() > 3) && (this.getPosY() > 3)) {
                    this.setPosX(this.getPosX() - 1);
                    this.setPosY(this.getPosY() - 1);
                }
                break;
            case 6:
                if(this.getPosX() > 3) {
                    this.setPosX(this.getPosX() - 1);
                }
                break;
            case 7:
                if(this.getPosY() > 3) {
                    this.setPosY(this.getPosY() - 1);
                }
                break;
            case 8:
                if(this.getPosX() < 637) {
                    this.setPosY(this.getPosY() + 1);
                }
                break;
        }

        this.precedenteDirection = i;

    }


}
