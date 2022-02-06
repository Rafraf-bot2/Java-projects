package fr.uvsq.cprog.requetes;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * Implementation de la classe Employe.
 * On utilise ici Projet Lombok https://projectlombok.org/features/Builder
 * afin de pouvoir creer plus facilement le jeu de données de test.
 */

@Data
@Builder

final class Employe {

    enum Sexe {
        HOMME, FEMME;
    };

    private String nom;
    private int age;
    private Sexe sexe;
    private BigDecimal salaire;
    private LocalDate dateEmbauche;
    private Service servRattachement;

    /**
     * Get le nom de l'employe.
     *
     * @return nom de l'employe
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Get l'age de l'employe.
     *
     * @return age de l'employe
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get le sexe de l'employe.
     *
     * @return sexe de l'employe
     */
    public Sexe getSexe() {
        return this.sexe;
    }

    /**
     * Get le salaire de l'employe.
     *
     * @return salaire de l'employe
     */
    public BigDecimal getSalaire() {
        return this.salaire;
    }

    /**
     * Get la date d'embauche de l'employe.
     *
     * @return dateEmbauche de l'employe
     */
    public LocalDate getDateEmbauche() {
        return this.dateEmbauche;
    }

    /**
     * Get le service de rattachement de l'employe.
     *
     * @return servRattachement de l'employe
     */
    public Service getServRattachement() {
        return this.servRattachement;
    }
}
