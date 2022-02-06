package fr.uvsq.cprog.dessin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation de la classe qui se charge.
 * des interactions utilisateurs
 */
public class Cli implements Serializable {
    private int nbMaxForme;
    private List<Rectangle> listRectangle;
    private List<Cercle> listCercle;
    private List<Integer> listCercleSel;
    private List<Integer> listRectangleSel;

    /**
     * Init de la classe.
     */
    public Cli() {
        nbMaxForme = 3;
        listCercle = new ArrayList<>();
        listRectangle = new ArrayList<>();
        listCercleSel = new ArrayList<>();
        listRectangleSel = new ArrayList<>();
    }

    /**
     * Affichage du main menu.
     */
    public void mainMenu() {
        System.out.println("Choisissez l'une des commandes ci-dessous :");
        System.out.println("1 : Dessiner une Forme");
        System.out.println("2 : Supprimer une Forme");
        System.out.println("3 : Deplacer une Forme");
        System.out.println("4 : Afficher Dessin");
        System.out.println("5 : Sauvegarder Dessin");
        System.out.println("6 : Charger Dessin");
        System.out.println("0 : Quitter");
    }

    /**
     * Affichage du menu de creation.
     */
    public void creationMenu() {
        System.out.println("Choisissez l'une des formes ci-dessous :");
        System.out.println("1 : Cercle");
        System.out.println("2 : Rectangle");
        System.out.println("3 : Retour au main menu");
        System.out.println("0 : Quitter");
    }

    /**
     * Affichage du menu de traitement.
     */
    public void traitementMenu() {
        System.out.println("Choisissez l'une des formes ci-dessous :");
        System.out.println("1 : Cercle");
        System.out.println("2 : Rectangle");
        System.out.println("3 : Les deux");
        System.out.println("4 : Retour au main menu");
        System.out.println("0 : Quitter");
    }

    /**
     * Lancement de l'option choisie dans.
     * le main menu
     */
    public void choixMain() {
        mainMenu();
        Scanner sc = new Scanner(System.in);
        int cmd;
        String line;
        try {
            line = sc.nextLine();
            cmd = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Erreur de saisie");
            cmd = 0;
        }
        switch (cmd) {
            case 1: // creation
                choixCreation();
                break;
            case 2: // suppression
                choixtraitement(0);
                break;
            case 3: // deplacement
                choixtraitement(1);
                break;
            case 4: // affichage
                afficherPlanche();
                break;
            case 5:
                sauvegardeDessin();
                break;
            case 6:
                chargementDessin();
                break;
            case 0:
                quitter();
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }
    }

    /**
     * Lancement de l'option choisie dans.
     * le menu de creation
     */
    public void choixCreation() {
        creationMenu();
        Scanner sc = new Scanner(System.in);
        int cmd;
        try {
            cmd = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Erreur de saisie");
            cmd = 0;
        }

        switch (cmd) {
            case 1: // Cercle
                creeCercle();
                break;
            case 2: // Rectangle
                creeRectangle();
                break;
            case 3: // Les
                choixMain();
                break;
            case 0: // Quitter
                quitter();
                break;
            default:
                break;
        }
    }

    /**
     * Lancement de l'option choisie dans.
     * le menu de traitement.
     *
     * @param choixTraitement 0 si suppression 1 sinon
     */
    public void choixtraitement(final int choixTraitement) {
        traitementMenu();
        Scanner sc = new Scanner(System.in);
        int cmd;
        try {
            cmd = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Erreur de saisie");
            cmd = 0;
        }

        switch (cmd) {
            case 1: // Cercle
                if (!listCercle.isEmpty()) {
                    selectionCercle();
                    if (choixTraitement == 0) {
                        supprimerForme();
                    } else {
                        deplacerForme();
                    }
                    listCercleSel.clear();
                } else {
                    System.out.println("Aucun cercle dessiné");
                }
                System.out.println(
                        "__________________________________________");
                break;
            case 2: // Rectangle
                if (!listRectangle.isEmpty()) {
                    selectionRectangle();
                    if (choixTraitement == 0) {
                        supprimerForme();
                    } else {
                        deplacerForme();
                    }
                    listRectangleSel.clear();
                } else {
                    System.out.println("Aucun rectangle dessiné");
                }
                System.out.println(
                        "__________________________________________");
                break;
            case 3: // Les deux
                if (!listCercle.isEmpty() & !listRectangle.isEmpty()) {
                    selectionCercle();
                    selectionRectangle();
                    if (choixTraitement == 0) {
                        supprimerForme();
                    } else {
                        deplacerForme();
                    }
                    listCercleSel.clear();
                    listRectangle.clear();
                } else {
                    System.out.println("Formes non dessiné");
                }
                System.out.println(
                        "__________________________________________");
                break;
            case 4: // Main menu
                System.out.println(
                        "__________________________________________");
                choixMain();
                break;
            case 0: // Quitter
                quitter();
                break;
            default:
                break;
        }
    }

    /**
     * Mettre fin au programme.
     */
    public void quitter() {
        System.out.println("See you space cowboy...");
        System.exit(0);
    }

    /**
     * Creation de point.
     *
     * @return Point
     */
    public Point creePoint() {
        double x;
        double y;
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer la coordonnée x > ");
        try {
            x = sc.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println(
                    "Erreur lors de la saisie, val par defaut (0.0) appliquée");
            x = 0d;
        }

        System.out.print(
                "Veuillez entrer la coordonnée y > ");
        try {
            y = sc.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println(
                    "Erreur lors de la saisie, val par defaut (0.0) appliquée");
            y = 0d;
        }
        return new Point(x, y);
    }

    /**
     * Creation de cercle.
     */
    public void creeCercle() {
        System.out.println("Creation cercle : ");
        if (listCercle.size() < nbMaxForme) {
            System.out.println(
                    "Creation du cercle " + listCercle.size() + " :");
            System.out.println(
                    "Veuillez entrer les coordonnées du centre du cercle : ");
            Point centre = creePoint();

            double rayon;
            Scanner sc = new Scanner(System.in);
            System.out.print("Veuillez entrer la valeur du rayon du cercle > ");
            try {
                rayon = sc.nextDouble();
            } catch (NumberFormatException e) {
                System.out.println(
                        "Erreur lors de la saisie, val par defaut (3.0) appliquée");
                rayon = 3d;
            }
            listCercle.add(new Cercle(centre, rayon));
            System.out.println("Cercle crée !");
        } else {
            System.out.println(
                    "Nombre max de cercle atteint veuillez en supprimer un");
        }

        System.out.println(
                "__________________________________________");
        choixMain();
    }

    /**
     * Creation de rectangle.
     */
    public void creeRectangle() {
        System.out.println("Creation rectangle : ");
        if (listRectangle.size() < nbMaxForme) {
            System.out.println(
                    "Creation du rectangle " + listRectangle.size() + " :");

            System.out.println(
                    "Veuillez entrer les coordonnées de l'angle haut droit :");
            Point hautDroit = creePoint();

            System.out.println(
                    "Veuillez entrer les coordonnées de l'angle bas gauche :");
            Point basGauche = creePoint();

            if (hautDroit.getX() < basGauche.getX() || hautDroit.getY() < basGauche.getY()) {
                System.out.println("Erreur de coordonnées");
                System.out.println(
                        "Correction automatique des coordonnés de l'angle bas gauche");
                listRectangle.add(new Rectangle(hautDroit,
                        new Point(hautDroit.getX() - 1, hautDroit.getY() - 1)));
            } else {
                listRectangle.add(new Rectangle(hautDroit, basGauche));
            }
            System.out.println("Rectangle crée !");
        } else {
            System.out.println(
                    "Nombre max de rectangle atteint veuillez en supprimer un");
        }

        System.out.println(
                "__________________________________________");
        choixMain();
    }

    /**
     * Affichage des cercles dessinés.
     */
    public void afficherCercle() {
        for (int i = 0; i < listCercle.size(); i++) {
            System.out.println("Cercle " + i
                    + " : " + listCercle.get(i).toString());
        }
    }

    /**
     * Affichage des rectangles dessinés.
     */
    public void afficherRectangle() {
        for (int i = 0; i < listRectangle.size(); i++) {
            System.out.println("Rectangle " + i
                    + " : " + listRectangle.get(i).toString());
        }
    }

    /**
     * Affichage du dessin global.
     */
    public void afficherPlanche() {
        if (listCercle != null) {
            afficherCercle();
        }
        if (listRectangle != null) {
            afficherRectangle();
        }

        System.out.println(
                "__________________________________________");
        choixMain();
    }

    /**
     * Selection du ou des cercles.
     * Pour traitement (suppression / deplacement)
     */
    public void selectionCercle() {
        Scanner sc = new Scanner(System.in);
        int numCercle = listCercle.size();
        int idSel = 0;

        System.out.println("Les cercles disponibles sont : ");
        afficherCercle();

        System.out.println("-1 : Fin de selection");

        while (numCercle > 0 & idSel != -1) {
            System.out.print("Selectionnez le cercle voulu via son numero > ");
            try {
                idSel = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Erreur de la saisie");
                idSel = -1;
            }
            if (idSel >= 0 & idSel < listCercle.size()) {
                listCercleSel.add(idSel);
            }
            numCercle--;
        }
        if (numCercle == 0 & idSel != -1) {
            System.out.println("Tous les cercles ont été selectionné");
        }
        if (idSel == -1) {
            System.out.println("Selection terminée");
        }
    }

    /**
     * Selection du ou des rectangles.
     * Pour traitement (suppression / deplacement)
     */
    public void selectionRectangle() {
        Scanner sc = new Scanner(System.in);
        int numRectangle = listRectangle.size();
        int idSel = 0;

        System.out.println("Les rectangles disponibles sont : ");
        afficherRectangle();

        System.out.println("-1 : Fin de selection");

        while (numRectangle > 0 & idSel != -1) {
            System.out.print(
                    "Selectionnez le rectangle voulu via son numero > ");
            try {
                idSel = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Erreur de la saisie");
                idSel = -1;
            }
            if (idSel >= 0 & idSel < listRectangle.size()) {
                listRectangleSel.add(idSel);
            }
            numRectangle--;
        }
        if (numRectangle == 0 & idSel != -1) {
            System.out.println("Tous les rectangles ont été selectionné");
        }
        if (idSel == -1) {
            System.out.println("Selection terminée");
        }
    }

    /**
     * Deplacement des formes selectionnées.
     */
    public void deplacerForme() {
        double x;
        double y;
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer la x valeur du deplacement >");
        try {
            x = sc.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println(
                    "Erreur lors de la saisie, aucun changement validé");
            x = 0d;
        }

        System.out.print("Veuillez entrer la y valeur du deplacement >");
        try {
            y = sc.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println(
                    "Erreur lors de la saisie, aucun changement validé");
            y = 0d;
        }

        if (listCercleSel != null) {
            for (int i = 0; i < listCercleSel.size(); i++) {
                listCercle.get(listCercleSel.get(i)).deplace(x, y);
                System.out.println(
                        "Le deplacement du cercle" + listCercleSel.get(i)
                                + " a donné : " + listCercle
                                        .get(listCercleSel.get(i)).toString());
            }
        }

        if (listRectangleSel != null) {
            for (int i = 0; i < listRectangleSel.size(); i++) {
                listRectangle.get(listRectangleSel.get(i)).deplace(x, y);
                System.out.println(
                        "Le deplacement du rectangle" + listRectangleSel.get(i)
                                + " a donné : " + listRectangle
                                        .get(listRectangleSel.get(i)).toString());
            }
        }
        System.out.println(
                "__________________________________________");
        listCercleSel.clear();
        listRectangleSel.clear();
        choixMain();
    }

    /**
     * Suppression des formes selectionnées.
     */
    public void supprimerForme() {
        if (listCercleSel != null) {
            for (int i = 0; i < listCercleSel.size(); i++) {
                listCercle.remove(listCercle.get(listCercleSel.get(i)));
                System.out.print("Le cercle "
                        + listCercleSel.get(i) + " a été supprimé");
            }
        }

        if (listRectangleSel != null) {
            for (int i = 0; i < listRectangleSel.size(); i++) {
                listRectangle.remove(listRectangle
                        .get(listRectangleSel.get(i)));
            }
        }
        System.out.println(
                "__________________________________________");
        listCercleSel.clear();
        listRectangleSel.clear();
        choixMain();
    }

    /**
     * Sauvegarde du dessin en cours.
     */
    public void sauvegardeDessin() {
        try {
            FileOutputStream outC = new FileOutputStream("cercles.out");
            ObjectOutputStream oosC = new ObjectOutputStream(outC);
            oosC.writeObject(listCercle);
            oosC.flush();
        } catch (Exception e) {
            System.out.println("Probleme de sauvegarde : " + e);
        }

        try {
            FileOutputStream outR = new FileOutputStream("rectangles.out");
            ObjectOutputStream oosR = new ObjectOutputStream(outR);
            oosR.writeObject(listRectangle);
            oosR.flush();
        } catch (Exception e) {
            System.out.println("Probleme de sauvegarde : " + e);
        }
    }

    /**
     * Chargement du dernier dessins sauvegardé.
     */
    public void chargementDessin() {
        try {
            FileInputStream inC = new FileInputStream("cercles.out");
            ObjectInputStream oisC = new ObjectInputStream(inC);
            listCercle = (List<Cercle>) oisC.readObject();
        } catch (Exception e) {
            System.out.println("Probleme de chargement : " + e);
        }

        try {
            FileInputStream inR = new FileInputStream("rectangles.out");
            ObjectInputStream oisR = new ObjectInputStream(inR);
            listRectangle = (List<Rectangle>) oisR.readObject();
        } catch (Exception e) {
            System.out.println("Probleme de chargement : " + e);
        }
    }

}
