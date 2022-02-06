package fr.uvsq.cprog.dessin;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class RectangleTest {
    private Rectangle r1, r2, r3;

    @Before
    public void setUp() {
        r1 = new Rectangle(new Point(5, 5), new Point(2, 3));
        r2 = new Rectangle(new Point(2, 0), new Point(0, -1));
        r3 = new Rectangle(new Point(12, 35), new Point(10, 20));
    }

    @Test
    public void gethDroitTest() {
        assertEquals(5d, r1.gethDroit().getX(), 0d);
        assertEquals(5d, r1.gethDroit().getY(), 0d);

        assertEquals(2d, r2.gethDroit().getX(), 0d);
        assertEquals(0d, r2.gethDroit().getY(), 0d);

        assertEquals(12d, r3.gethDroit().getX(), 0d);
        assertEquals(35d, r3.gethDroit().getY(), 0d);
    }

    @Test
    public void getbGaucheTest() {
        assertEquals(2d, r1.getbGauche().getX(), 0d);
        assertEquals(3d, r1.getbGauche().getY(), 0d);

        assertEquals(0d, r2.getbGauche().getX(), 0d);
        assertEquals(-1d, r2.getbGauche().getY(), 0d);

        assertEquals(10d, r3.getbGauche().getX(), 0d);
        assertEquals(20d, r3.getbGauche().getY(), 0d);
    }

    @Test
    public void deplaceTest(){
        r1.deplace(1, -10);
        assertEquals(6d, r1.gethDroit().getX(), 0d);
        assertEquals(-5d, r1.gethDroit().getY(), 0d);
        assertEquals(3d, r1.getbGauche().getX(), 0d);
        assertEquals(-7d, r1.getbGauche().getY(), 0d);

        r2.deplace(0, 0);
        assertEquals(2d, r2.gethDroit().getX(), 0d);
        assertEquals(0d, r2.gethDroit().getY(), 0d);
        assertEquals(0d, r2.getbGauche().getX(), 0d);
        assertEquals(-1d, r2.getbGauche().getY(), 0d);
    }

    @Test
    public void testtoString() {
        assertEquals("[(5.0, 5.0), (2.0, 3.0)]", r1.toString());
        assertEquals("[(2.0, 0.0), (0.0, -1.0)]", r2.toString());
        assertEquals("[(12.0, 35.0), (10.0, 20.0)]", r3.toString());
    }

}
