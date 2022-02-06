package fr.uvsq.cprog.dessin;

public class Main {
    public static void main(String[] args) {
        Cli cliUser = new Cli();
        System.out.println("*** CLI Drawer ***");
        while (true) {
            cliUser.choixMain();
        }
    }
}
