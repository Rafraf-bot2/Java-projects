package fr.uvsq.cprog.dns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Implementation de la classe Dns.
 */
public class Dns {
    private HashMap<AdresseIP, NomMachine> ipMachine;
    private HashMap<NomMachine, AdresseIP> machineIp;

    /**
     * Init de Dns.
     */
    public Dns() {
        ipMachine = new HashMap<AdresseIP, NomMachine>();
        machineIp = new HashMap<NomMachine, AdresseIP>();
    }

    /**
     * Init de la BD.
     *
     * @throws FileNotFoundException cas ou le fichier n'existe pas
     * @throws IOException           //
     */
    public void initDb() throws FileNotFoundException, IOException {
        Scanner sc = null;
        InputStream in = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(in);
        File f = new File(prop.getProperty("dbdns"));
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] args = sc.nextLine().split(" ");
                ipMachine.put(new AdresseIP(args[1]), new NomMachine(args[0]));
                machineIp.put(new NomMachine(args[0]), new AdresseIP(args[1]));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * retourne une instance de DnsItem selon l'entrée.
     *
     * @param ip @ip en entrée
     * @return DnsItem
     * @throws FileNotFoundException //
     * @throws IOException           //
     */
    public DnsItem getItem(final AdresseIP ip)
            throws FileNotFoundException, IOException {
        initDb();
        DnsItem d1 = null;
        for (Map.Entry<AdresseIP, NomMachine> elt : this.ipMachine.entrySet()) {
            if (elt.getKey().getAdr().equals(ip.getAdr())) {
                d1 = new DnsItem(ip, elt.getValue());
                break;
            } else {
                NomMachine nameM = new NomMachine("inconnu.inconnu");
                d1 = new DnsItem(ip, nameM);
            }
        }
        return d1;
    }

    /**
     * retourne une instance de DnsItem selon l'entrée.
     *
     * @param nameM nomMachine en entrée
     * @return DnsItem
     * @throws FileNotFoundException //
     * @throws IOException           //
     */
    public DnsItem getItem(final NomMachine nameM)
            throws FileNotFoundException, IOException {
        initDb();
        DnsItem d1 = null;
        for (Map.Entry<NomMachine, AdresseIP> elt : this.machineIp.entrySet()) {
            if (elt.getKey().getNom().equals(nameM.getNom())) {
                d1 = new DnsItem(elt.getValue(), nameM);
                break;
            } else {
                AdresseIP ip = new AdresseIP("NaN.NaN.NaN.NaN");
                d1 = new DnsItem(ip, nameM);
            }
        }
        return d1;
    }

}
