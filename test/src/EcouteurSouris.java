import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class EcouteurSouris implements MouseListener {
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Clic");
    }
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}