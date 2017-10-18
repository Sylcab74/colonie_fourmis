package fourmi;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MenuInfo menuInfo;
        Menu menu = new Menu();

        menu.setSize(400, 250);
        menu.setUndecorated(true);
        menu.setLocationRelativeTo(null);
        menu.show();

        menuInfo = menu.getValue();

        Simulation sim = new Simulation(menuInfo.getNbNourriture(),menuInfo.getNbFourmi(), menuInfo.getVitessePheromone());

        Rendu rendu = new Rendu(sim);
        rendu.setBackground(Color.WHITE);

        while (true) {
            sim.nextStep();
            rendu.paint(sim);
            try { Thread.sleep(25); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
