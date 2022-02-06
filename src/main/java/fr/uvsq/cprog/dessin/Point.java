package fr.uvsq.cprog.dessin;

import java.io.Serializable;

/**
 * Implementation de la classe Point.
 */
public class Point implements Serializable{
    private double x;
    private double y;

/**
 * Init du point.
 * @param cx coordonee x
 * @param cy coordonee y
 */
    public Point(final double cx, final double cy) {
        this.x = cx;
        this.y = cy;
    }

    /**
     * get la coordonnee x.
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * get la coordonnee y.
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * affiche le point sous forme (x, y).
     * @return le point (x, y)
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * Effectue une translation du point selon les parametres.
     * @param depx translation de x
     * @param depy translation de y
     */
    public void deplace(final double depx, final double depy) {
        this.x += depx;
        this.y += depy;
    }
}
