package fr.uvsq.cprog.requetes;
/**
 *  Services existants.
 */
public enum Service {
    /**
     * Infromatique.
     */
    INFO("Infromatique", "4 rue de l'info"),

    /**
     * Marketing.
     */
    MARKET("Marketing", "4 rue du marketing"),

    /**
     * Ressources Humaines.
     */
    RH("Ressources Humaines", "4 rue de l'RH"),

    /**
     * Juridique.
     */
    JURD("Juridique", "4 rue de la juridiction");

    private String nomService;
    private String adresseService;

    Service(final String nm, final String ad) {
        this.nomService = nm;
        this.adresseService = ad;
    }
}
