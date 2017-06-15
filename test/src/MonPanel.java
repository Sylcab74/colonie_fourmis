import javax.swing.*;
import java.awt.*;

class MonJPanel extends JPanel {
    int nbAppels;
    public int x = 120;
    public int y = 120;
    public Color color = Color.BLUE;

    MonJPanel() {
        nbAppels = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        nbAppels++;
        //System.out.println("Appel numéro :" + nbAppels);

        g.setColor(Color.BLACK);
        g.drawOval(this.x, this.y, 40, 40);
        g.setColor(this.color);
        g.fillOval(this.x + 1, this.y + 1, 38, 38);


    }
}