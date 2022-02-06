package fr.uvsq.cprog.dns;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * implementation de la classe exec.
 */
public class Exec implements Command {
    private String typ;
    private String arg;

    /**
     * init de exec.
     */
    public Exec() {
        typ = "";
        arg = "";
    }

    /**
     * execution de la commande.
     *
     * @param t type de la commande
     * @param a argument
     */
    public void execute(final String t, final String a)
            throws FileNotFoundException, IOException {
        Dns dns = new Dns();
        dns.initDb();

        if (t.equals("machine")) {
            NomMachine nom = new NomMachine(a);
            System.out.println(dns.getItem(nom).getIp().getAdr());
        } else if (t.equals("adresse")) {
            AdresseIP ip = new AdresseIP(a);
            System.out.println(dns.getItem(ip).getMachine().getNom());
        } else {
            System.out.println("Commande non reconnue");
        }
    }
}
