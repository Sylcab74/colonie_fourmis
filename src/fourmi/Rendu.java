package fourmi;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Rendu extends JPanel{
    private JFrame frame = new JFrame();
    private Simulation sim;
    private Map<Point, Integer> Nourriture = new HashMap<Point, Integer>();



    public Rendu( Simulation sim) {

        this.sim = sim;

        frame.setSize(640, 640);
        frame.setTitle("Projet Java Fourmilière");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    public void paint(Simulation sim) {
        this.sim = sim;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(sim.getFourmiliere().getColor());
        g.fillRect(sim.getFourmiliere().getPosX(), sim.getFourmiliere().getPosY(), 15, 15);

        g.setColor(Color.BLACK);


        for (Fourmi fourmi : sim.getFourmis()) {
            g.setColor(fourmi.getColor());
            g.fillOval(fourmi.getPosX(), fourmi.getPosY(), 13, 13);
        }

        for (Pheromone pheromone : sim.getPheromones()) {
            if(pheromone.getVie() > 0){
                g.setColor(new Color(0,125,125,pheromone.getTransparence()));
                g.fillOval(pheromone.getPosX(), pheromone.getPosY(), 13, 13);
            }
        }

        for(Nourriture nour : sim.getNourritures()){
            g.setColor(nour.getColor());
            int width = nour.getVie() * 2;
            int height = nour.getVie() * 2;
            g.fillRect(nour.getPosX(), nour.getPosY(), width, height);
            Nourriture.put(nour.getPos(), nour.getVie());
        }

    }
}
