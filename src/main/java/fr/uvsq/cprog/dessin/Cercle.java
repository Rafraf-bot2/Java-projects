package fr.uvsq.cprog.dessin;

import java.io.Serializable;

/**
 * Implementation de la classe Cercle.
 */
public class Cercle extends Forme implements Serializable{
    private Point centre;
    private double rayon;

    /**
     * Init du cercle.
     * @param c coordonee du cercle
     * @param r taille du rayon
     */
    public Cercle(final Point c, final Double r) {
        this.centre = c;
        this.rayon = r;
    }

    /**
     * get le centre.
     * @return centre
     */
    public Point getCentre() {
        return this.centre;
    }

    /**
     * get le rayon.
     * @return rayon
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * effectue une translation du cercle.
     * il suffit d'effectuer une translation sur le centre
     * @param depx translation de x du centre
     * @param depy translation de y du centre
     */
    public void deplace(final double depx, final double depy) {
        centre.deplace(depx, depy);
    }

    /**
     * affiche le cercle sous la forme [(x, y), r].
     * @return le cercle [(x, y), r]
     */
    @Override
    public String toString() {
        return "[" + centre.toString() + ", " + rayon + "]";
    }
}
