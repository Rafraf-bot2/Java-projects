package fr.uvsq.cprog.dns;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class AdresseIPTest {
    AdresseIP a1, a2;

    @Before
    public void setUp() {
        a1 = new AdresseIP("192.168.1.1");
        a2 = new AdresseIP("178.255.1.1");
    }

    @Test
    public void toStringTest() {
        assertEquals("192.168.1.1", a1.getAdr());
        assertEquals("178.255.1.1", a2.getAdr());
    }
}
