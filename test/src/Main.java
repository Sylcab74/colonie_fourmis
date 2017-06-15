import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        JFrame f = new JFrame();
        f.setSize(400, 400);//dimensions
        f.setTitle("Ma première fenêtre swing");//titre
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fermeture de la fenetre -> arret du programme
        //Position de la fenetre
        f.setLocation(400, 400);
        MonJPanel p = new MonJPanel();
        f.add(p);
        f.setVisible(true);

        int i = 0;


        for (int j = 0; j <  20; j++) {

            Random rand = new Random();
            i = rand.nextInt(8)+1;
            System.out.println("Random :" + i);
        }

        p.y = 120;
        p.x = 120;
        int mid = p.x/2;
        while (p.x >= 0 & p.x <= 360 & p.y >= 0 & p.y <= 360) {

            Random rand = new Random();
            i = rand.nextInt(8)+1;
            System.out.println("Random :" + i);

            if(p.x == mid){
                p.color = Color.GREEN;
            }

            switch (i)
            {
                case 1:
                    p.x = p.x + 2;
                    break;
                case 2:
                    p.x = p.x + 2;
                    p.y = p.y + 2;
                    break;
                case 3:
                    p.x = p.x + 2;
                    p.y = p.y - 2;
                    break;
                case 4:
                    p.x = p.x - 2;
                    p.y = p.y + 2;
                    break;
                case 5:
                    p.x = p.x - 2;
                    p.y = p.y - 2;
                    break;
                case 6:
                    p.x = p.x - 2;
                    break;
                case 7:
                    p.y = p.y - 2;
                    break;
                case 8:
                    p.y = p.y + 2;
                    break;
                default:
                    System.out.println("Il faut davantage travailler.");
            }
            p.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //f.setLocationRelativeTo(null);
        //bouton et contours de la fenêtre
        //f.setUndecorated(true);
        //visibilité


    }
}