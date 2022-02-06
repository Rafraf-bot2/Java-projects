package fr.uvsq.cprog.dns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DnsApp {
    /**
     * execution du programme.
     * @param args //
     * @throws FileNotFoundException //
     * @throws IOException //
     */
    public static void main(final String[] args)
    throws FileNotFoundException, IOException {
        System.out.println("***DNS Simulator***");
        System.out.println(
            "Entrer une @ ip (ex : 1.0.0.0) ou un nom de machine (ex : machine.domaine)");
        System.out.println("Entrer 'Quitter' pour quitter l'app");

        DnsTUI tui = new DnsTUI();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmd;
            System.out.print(">> ");
            if (sc.hasNextLine()) {
                cmd = sc.nextLine();
                tui.nextCommande(cmd);
            }
        }
    }
}
