package fr.uvsq.cprog.dns;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class NomMachineTest {
    private NomMachine n1, n2;

    @Before
    public void setUp()
    {
        n1 = new NomMachine("machine1.domaine1");
        n2 = new NomMachine("machine2.domaine2");
    }

    @Test
    public void getNomTest(){
        assertEquals("machine1.domaine1", n1.getNom());
        assertEquals("machine2.domaine2", n2.getNom());
    }
}
