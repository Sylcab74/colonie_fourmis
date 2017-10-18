package fourmi;

public class MenuInfo {
    private int nbFourmi;
    private int nbNourriture;
    private int vitessePheromone;

    public MenuInfo(int nbFourmi, int nbNourriture, int vitessePheromone) {
        this.nbFourmi = nbFourmi;
        this.nbNourriture = nbNourriture;
        this.vitessePheromone = vitessePheromone;
    }

    public int getNbFourmi() {
        return nbFourmi;
    }

    public void setNbFourmi(int nbFourmi) {
        this.nbFourmi = nbFourmi;
    }

    public int getNbNourriture() {
        return nbNourriture;
    }

    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }

    public int getVitessePheromone() {
        return vitessePheromone;
    }

    public void setVitessePheromone(int vitessePheromone) {
        this.vitessePheromone = vitessePheromone;
    }
}