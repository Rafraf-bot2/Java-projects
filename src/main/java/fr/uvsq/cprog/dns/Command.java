package fr.uvsq.cprog.dns;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Implementation de l'interface Command.
 */
public interface Command {
    /**
     * Methode execute a instancier.
     *
     * @param typ type de commande
     * @param arg valeur de la command
     * @throws FileNotFoundException //
     * @throws IOException           //
     */
    void execute(String typ, String arg)
            throws FileNotFoundException, IOException;
}
