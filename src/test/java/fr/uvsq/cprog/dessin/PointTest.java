package fr.uvsq.cprog.dessin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
    private Point p1, p2, p3;

    @Before
    public void setUp() {
        p1 = new Point(5, 6);
        p2 = new Point(3.5, -2);
        p3 = new Point(0, 0);
    }

    @Test
    public void testgetX() {
        assertEquals(5d, p1.getX(), 0d);
        assertEquals(3.5, p2.getX(), 0d);
        assertEquals(0d, p3.getX(), 0d);
    }

    @Test
    public void testgetY() {
        assertEquals(6d, p1.getY(), 0d);
        assertEquals(-2d, p2.getY(), 0d);
        assertEquals(0d, p3.getY(), 0d);
    }

    @Test
    public void testtoString() {
        assertEquals("(5.0, 6.0)", p1.toString());
        assertEquals("(3.5, -2.0)", p2.toString());
        assertEquals("(0.0, 0.0)", p3.toString());
    }

    @Test
    public void testdeplace() {
        p1.deplace(1, 1);
        assertEquals(6d ,p1.getX(), 0d);
        assertEquals(7d ,p1.getY(), 0d);

        p2.deplace(0.5, -1);
        assertEquals(4d ,p2.getX(), 0d);
        assertEquals(-3d ,p2.getY(), 0d);

        p3.deplace(0, 50);
        assertEquals(0d ,p3.getX(), 0d);
        assertEquals(50d ,p3.getY(), 0d);
    }
}
