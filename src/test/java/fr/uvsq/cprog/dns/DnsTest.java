package fr.uvsq.cprog.dns;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
public class DnsTest {
    Dns d1, d2;

    @Before
    public void setUp() {
        d1 = new Dns();
        d2 = new Dns();
    }

    @Test
    public void getItem() throws FileNotFoundException, IOException {
        AdresseIP ip1 = new AdresseIP("1.1.1.1");
        NomMachine m1 = new NomMachine("ordi1.domaine1");
        DnsItem di1 = new DnsItem(ip1, m1);

        AdresseIP ip2 = new AdresseIP("adr");
        NomMachine m2 = new NomMachine("ordi2.domaine2");
        DnsItem di2 = new DnsItem(ip2, m2);

        assertEquals(di1.getIp().getAdr(), d1.getItem(ip1).getIp().getAdr());
        assertEquals(di1.getMachine().getNom(), d1.getItem(m1).getMachine().getNom());

        assertEquals(di2.getIp().getAdr(), d2.getItem(ip2).getIp().getAdr());
        assertEquals(di2.getMachine().getNom(), d2.getItem(m2).getMachine().getNom());
    }

    
}
