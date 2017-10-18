package fourmi;

import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;


public class Element {
    protected int posX;
    protected int posY;
    protected Color color;

    public Element(int posX, int posY, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.color = new Color(255,255,255,125);
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
