package fr.uvsq.cprog.dns;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * implementation de DnsTUI.
 */
public class DnsTUI {
    private Exec exe;

    /**
     * init de dnstui.
     */
    public DnsTUI() {
        exe = new Exec();
    }

    /**
     * interpreteation des commandes.
     *
     * @param cmd la commande
     * @throws FileNotFoundException //
     * @throws IOException           //
     */
    public void nextCommande(final String cmd)
            throws FileNotFoundException, IOException {
        int nbPoint = 0;
        char car;
        for (int i = 0; i < cmd.length(); i++) {
            car = cmd.charAt(i);
            if (car == '.') {
                nbPoint++;
            }
        }
        if (nbPoint == 3) {
            this.exe.execute("adresse", cmd);
        } else if (nbPoint == 1) {
            this.exe.execute("machine", cmd);
        } else if (cmd.equals("Quitter")) {
            System.out.println("Bye bye");
            System.exit(0);
        } else {
            System.out.println("Commande non reconnue");
        }
    }
}
