package fr.uvsq.cprog.dessin;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class CercleTest {
    private Cercle c1, c2, c3;

    @Before
    public void setUp() {
        c1 = new Cercle(new Point(5, 6), 3d);
        c2 = new Cercle(new Point(1.5, -2), 4d);
        c3 = new Cercle(new Point(0, 0), 20d);
    }

    @Test
    public void testgetCentre() {
        assertEquals(5d, c1.getCentre().getX(), 0d);
        assertEquals(6d, c1.getCentre().getY(), 0d);

        assertEquals(1.5, c2.getCentre().getX(), 0d);
        assertEquals(-2d, c2.getCentre().getY(), 0d);

        assertEquals(0d, c3.getCentre().getX(), 0d);
        assertEquals(0d, c3.getCentre().getY(), 0d);

    }

    @Test
    public void testgetRayon() {
        assertEquals(3d, c1.getRayon(), 0d);
        assertEquals(4d, c2.getRayon(), 0d);
        assertEquals(20d, c3.getRayon(), 0d);
    }

    @Test
    public void testdeplace() {
        c1.deplace(1, -7);
        assertEquals(6d, c1.getCentre().getX(), 0d);
        assertEquals(-1d, c1.getCentre().getY(), 0d);

        c2.deplace(0, 0);
        assertEquals(1.5, c2.getCentre().getX(), 0d);
        assertEquals(-2d, c2.getCentre().getY(),0d);
    }

    @Test
    public void testtoString() {
        assertEquals("[(5.0, 6.0), 3.0]", c1.toString());
        assertEquals("[(1.5, -2.0), 4.0]", c2.toString());
        assertEquals("[(0.0, 0.0), 20.0]", c3.toString());
    }
}
