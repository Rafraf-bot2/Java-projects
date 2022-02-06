package fr.uvsq.cprog.dns;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class DnsItemTest {
    DnsItem d1, d2;

    @Before
    public void setUp() {
        AdresseIP ip1 = new AdresseIP("1.1.1.1");
        NomMachine m1 = new NomMachine("machine.dodo");
        AdresseIP ip2 = new AdresseIP("0.0.0.0");
        NomMachine m2 = new NomMachine("mama.domaine");

        d1 = new DnsItem(ip1, m1);
        d2 = new DnsItem(ip2, m2);
    }

    @Test
    public void getIpTest() {
        assertEquals("1.1.1.1", d1.getIp().getAdr());
        assertEquals("0.0.0.0", d2.getIp().getAdr());
    }

    @Test
    public void getNomMTest() {
        assertEquals("machine.dodo", d1.getMachine().getNom());
        assertEquals("mama.domaine", d2.getMachine().getNom());
    }

    @Test
    public void getDnsItemTest() {
        assertEquals("1.1.1.1 machine.dodo", d1.getDnsItem());
        assertEquals("0.0.0.0 mama.domaine", d2.getDnsItem());
    }
}
