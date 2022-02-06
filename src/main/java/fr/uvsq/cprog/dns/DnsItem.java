package fr.uvsq.cprog.dns;

/**
 * Implementation de la classe DnsItem.
 */
public class DnsItem {
    private AdresseIP ip;
    private NomMachine nomM;

    /**
     * Init de dnsitem.
     *
     * @param adr  @ip
     * @param name nommachine
     */
    public DnsItem(final AdresseIP adr, final NomMachine name) {
        ip = adr;
        nomM = name;
    }

    /**
     * retourne @ip.
     *
     * @return @ip
     */
    public AdresseIP getIp() {
        return ip;
    }

    /**
     * retourne nommachine.
     *
     * @return nommachine
     */
    public NomMachine getMachine() {
        return nomM;
    }

    /**
     * retourne dnsitem sous forme de string.
     *
     * @return x.x.x.x machine.domaine
     */
    public String getDnsItem() {
        return ip.getAdr() + " " + nomM.getNom();
    }
}
