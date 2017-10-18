package fourmi;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class Simulation {
    private ArrayList<Fourmi> fourmis;
    private ArrayList<Pheromone> pheromones;
    private HashSet<Nourriture> nourritures;
    private Fourmiliere fourmiliere;

    private int nbNourritures;
    private int nbFourmis;
    private int vitesseEvaporation;
    private int nbTour;

    public Simulation(int nbNourritures, int nbFourmis, int vitesseEvaporation) {
        this.fourmis = new ArrayList<Fourmi>();
        this.pheromones = new ArrayList<Pheromone>();

        this.nourritures = new HashSet<Nourriture>();

        this.fourmiliere = new Fourmiliere(320, 320);

        this.nbTour = 0;

        this.vitesseEvaporation = vitesseEvaporation;
        this.nbFourmis = nbFourmis;
        this.nbNourritures = nbNourritures;

        this.ajoutFourmi();
        this.ajoutNourriture();
    }

    public void nextStep() {
        this.nbTour++;

        for (Fourmi fourmi :
                this.fourmis) {
            if (!fourmi.isDetectNourriture() && !fourmi.isSuitPheromone() && !fourmi.isNourritureTransporte()) {
                fourmi.deplacementAleatoire();
            }else if(fourmi.isNourritureTransporte()){
                if(nbTour%15==0){
                    Pheromone pheromone = new Pheromone(fourmi.getPosX(),fourmi.getPosY(), vitesseEvaporation);

                    this.pheromones.add(pheromone);
                }

                if(allerSurPoint(fourmi, fourmiliere.getPosY(), fourmiliere.getPosY())){
                    fourmi.setNourritureTransporte(false);
                    fourmi.setNourritureVue(null);
                    fourmi.setDetectNourriture(false);
                    fourmi.setColor(Color.BLACK);
                }
            }else if(fourmi.isDetectNourriture()){
                Nourriture nour = fourmi.getNourritureVue();
                if(allerSurPoint(fourmi, nour.getPosY(), nour.getPosX()) && nour.getVie()>=0){
                    fourmi.setNourritureTransporte(true);
                    nour.setVie(nour.getVie()-1);
                    fourmi.setColor(new Color(255, 0, 15));
                    fourmi.setDetectNourriture(false);
                }
                else if(nour.getVie() < 0){
                    fourmi.setDetectNourriture(false);
                }
            }else if(fourmi.isSuitPheromone()){
                Pheromone phero = fourmi.getPheromoneCourrante();
                if(allerSurPoint(fourmi, phero.getPosY(), phero.getPosX())){
                    fourmi.setPheromonePrecedente(phero);
                }
            }

            for (Nourriture nourriture :
                    this.nourritures) {
                if (nourriture.getVie() > 0) {
                    if (Math.abs(fourmi.getPosX() - nourriture.getPosX()) <= 20 && Math.abs(fourmi.getPosY() - nourriture.getPosY()) <= 20) {
                        fourmi.setDetectNourriture(true);
                        fourmi.setNourritureVue(nourriture);
                        break;
                    }
                }
            }

            for (Pheromone pheromone:
                    this.pheromones) {
                pheromone.setNbTours(pheromone.getNbTours()+1);
                if(pheromone.getVie() > 0) {
                    if (pheromone.getNbTours() % pheromone.getEvaporation() == 0) {
                        pheromone.setVie(pheromone.getVie() - 1);
                        pheromone.setTransparence(pheromone.getTransparence() - pheromone.getIncrementationTransparence());
                        pheromone.setColor(new Color(0,125,125, pheromone.getTransparence()));
                    }
                }
                else{
                    pheromone.setColor(new Color(255,255,255));
                }
            }

        }
    }


    public void ajoutFourmi() {
        for (int i = 0; this.nbFourmis > i; i++) {
            Fourmi fourmi = new Fourmi(fourmiliere.getPosX(), fourmiliere.getPosY());
            this.fourmis.add(fourmi);
        }
    }

    public void ajoutNourriture() {
        Random ran = new Random();
        for (int i = 0; this.nbNourritures > i; i++) {
            Nourriture nourriture = new Nourriture(ran.nextInt(625), ran.nextInt(625));
            this.nourritures.add(nourriture);
        }
    }

    public boolean allerSurPoint(Fourmi f, int objectifPosY, int objectifPosX){
        Random ran = new Random();
        int i = ran.nextInt(100);
        if (i < 65) {
            if ((f.getPosY() - objectifPosY) > 1) {
                f.setPosY(f.getPosY() - 1);
            }
            if (f.getPosY() - objectifPosY < -1) {
                f.setPosY(f.getPosY() + 1);
            }
            if ((f.getPosX() - objectifPosX) > 1) {
                f.setPosX(f.getPosX() - 1);
            }
            if ((f.getPosX() - objectifPosX) < -1) {
                f.setPosX(f.getPosX() + 1);
            }
        }
        else{
            f.deplacementAleatoire();
        }

        if(
                (f.getPosX()- objectifPosX < 2) &&
                (f.getPosX()- objectifPosX > -2) &&
                (f.getPosY() - objectifPosY < 2) &&
                (f.getPosY() - objectifPosY > -2)
           ){
            return true;
        }else{
            return false;
        }
    }

    public Fourmiliere getFourmiliere() {
        return fourmiliere;
    }

    public ArrayList<Fourmi> getFourmis() {
        return fourmis;
    }

    public ArrayList<Pheromone> getPheromones() {
        return pheromones;
    }

    public HashSet<Nourriture> getNourritures() {
        return nourritures;
    }
}
