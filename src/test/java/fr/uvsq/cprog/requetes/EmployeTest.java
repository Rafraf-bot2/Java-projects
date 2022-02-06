package fr.uvsq.cprog.requetes;

import java.math.BigDecimal;
import java.time.LocalDate;
import fr.uvsq.cprog.requetes.Employe.Sexe;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class EmployeTest {
    private Employe emp1, emp2, emp3;

    @Before
    public void setUp() throws Exception {
        emp1 = Employe.builder().nom("Maxime Biaggi").age(22).sexe(Sexe.HOMME).salaire(new BigDecimal(2300)).
        dateEmbauche(LocalDate.of(2020, 1, 8)).servRattachement(Service.MARKET).build();

        emp2 = Employe.builder().nom("Jennie Kim").age(24).sexe(Sexe.FEMME).salaire(new BigDecimal(4001))
        .dateEmbauche(LocalDate.of(2020, 1, 31)).servRattachement(Service.INFO).build();

        emp3 = Employe.builder().nom("Juan Borja").age(54).sexe(Sexe.HOMME).salaire(new BigDecimal(6213))
        .dateEmbauche(LocalDate.of(2005, 11, 8)).servRattachement(Service.INFO).build();
    }

    @Test
    public void testgetNom() {
        assertEquals("Maxime Biaggi", emp1.getNom());
        assertEquals("Jennie Kim", emp2.getNom());
        assertEquals("Juan Borja", emp3.getNom());
    }

    @Test
    public void testgetAge() {
        assertEquals(22, emp1.getAge());
        assertEquals(24, emp2.getAge());
        assertEquals(54, emp3.getAge());
    }

    @Test
    public void testgetSexe() {
        assertEquals(Sexe.HOMME, emp1.getSexe());
        assertEquals(Sexe.FEMME, emp2.getSexe());
        assertEquals(Sexe.HOMME, emp3.getSexe());
    }

    @Test
    public void testgetSalaire() {
        assertEquals(new BigDecimal(2300), emp1.getSalaire());
        assertEquals(new BigDecimal(4001), emp2.getSalaire());
        assertEquals(new BigDecimal(6213), emp3.getSalaire());
    }

    @Test
    public void testgetDateEmbauche() {
        assertEquals(LocalDate.of(2020, 1, 8), emp1.getDateEmbauche());
        assertEquals(LocalDate.of(2020, 1, 31), emp2.getDateEmbauche());
        assertEquals(LocalDate.of(2005, 11, 8), emp3.getDateEmbauche());
    }

    @Test
    public void testgetServRattachement() {
        assertEquals(Service.MARKET, emp1.getServRattachement());
        assertEquals(Service.INFO, emp2.getServRattachement());
        assertEquals(Service.INFO, emp3.getServRattachement());
    }
    
}
