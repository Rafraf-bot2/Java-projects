package fr.uvsq.cprog.dessin;

import java.io.Serializable;

/**
 * Implementation de la classe Rectangle.
 */
public class Rectangle extends Forme implements Serializable{
    private Point hDroit;
    private Point bGauche;

    /**
     * Init du reclangle.
     * @param d angle superieur droit
     * @param g angle inferieur gauche
     */
    public Rectangle(final Point d, final Point g) {
        this.hDroit = d;
        this.bGauche = g;
    }

    /**
     * get l'angle superieur droit.
     * @return angle sup droit
     */
    public Point gethDroit() {
        return hDroit;
    }

    /**
     * get l'angle inferieur gauche.
     * @return angle inf gauche
     */
    public Point getbGauche() {
        return bGauche;
    }

    /**
     * effectue une translation du rectangle.
     * @param depx translation de x de l'angle sup droit
     * et de l'angle inf gauche
     * @param depy translation de y de l'angle sup droit
     * et de l'angle inf gauche
     */
    @Override
    public void deplace(final double depx, final double depy) {
        hDroit.deplace(depx, depy);
        bGauche.deplace(depx, depy);
    }

    /**
     * affiche le rectangle sous la forme [(x, y), (x, y)].
     * @return le rectangle [(x, y), (x, y)]
     */
    @Override
    public String toString() {
        return "[" + hDroit.toString() + ", " + bGauche.toString() + "]";
    }
}
