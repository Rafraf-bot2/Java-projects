package fr.uvsq.cprog.dns;

/**
 * Implementation de la classe Adresse ip.
 */
public class AdresseIP {
    private String ip;

    /**
     * init de l'@ ip.
     *
     * @param adr reperesentation de l'@
     */
    public AdresseIP(final String adr) {
        ip = adr;
    }

    /**
     * get de l'@.
     *
     * @return String @ip x.x.x.x
     */
    public String getAdr() {
        return ip;
    }
}
