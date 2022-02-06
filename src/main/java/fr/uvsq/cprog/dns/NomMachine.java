package fr.uvsq.cprog.dns;

/**
 * implementation de nommachine.
 */
public class NomMachine {
    private String nom;

    /**
     * init de nommachine.
     *
     * @param name nommachine.
     */
    public NomMachine(final String name) {
        nom = name;
    }

    /**
     * retourne nommachine.
     *
     * @return nom.domaine
     */
    public String getNom() {
        return nom;
    }
}
