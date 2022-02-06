package fr.uvsq.cprog.requetes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import fr.uvsq.cprog.requetes.Employe.Sexe;

/**
 * Implementation de la classe Requests.
 * Les requetes seront decrites dans cette classe.
 */
public class Requests {
        /**
         * Creation de jeu de données de test grace a Lombok Builder.
         * https://projectlombok.org/features/Builder
         *
         * @return List<Employe>
         */
        public static List<Employe> employes() {
                return new ArrayList<Employe>() {
                        {
                                add(Employe.builder().nom("Maxime Biaggi").age(22)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(2300))
                                                .dateEmbauche(LocalDate.of(2020, 1, 8))
                                                .servRattachement(Service.MARKET)
                                                .build());
                                add(Employe.builder().nom("Pete Party").age(32)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(3100))
                                                .dateEmbauche(LocalDate.of(2017, 9, 30))
                                                .servRattachement(Service.RH)
                                                .build());
                                add(Employe.builder().nom("Benson Stevens").age(45)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(4200))
                                                .dateEmbauche(LocalDate.of(2006, 4, 12))
                                                .servRattachement(Service.JURD)
                                                .build());
                                add(Employe.builder().nom("Jodie Holmes").age(26)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(3076))
                                                .dateEmbauche(LocalDate.of(2016, 2, 14))
                                                .servRattachement(Service.JURD)
                                                .build());
                                add(Employe.builder().nom("Juan Borja").age(54)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(6213))
                                                .dateEmbauche(LocalDate.of(2005, 11, 8))
                                                .servRattachement(Service.INFO)
                                                .build());
                                add(Employe.builder().nom("Mio Sunmi").age(36)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(2300))
                                                .dateEmbauche(LocalDate.of(2021, 6, 24))
                                                .servRattachement(Service.MARKET).build());
                                add(Employe.builder().nom("Channi Kynes").age(29)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(3000))
                                                .dateEmbauche(LocalDate.of(2021, 9, 11))
                                                .servRattachement(Service.RH)
                                                .build());
                                add(Employe.builder().nom("Jennie Kim").age(24)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(4001))
                                                .dateEmbauche(LocalDate.of(2020, 1, 31))
                                                .servRattachement(Service.INFO)
                                                .build());
                                add(Employe.builder().nom("Paul Atreides").age(29)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(2980))
                                                .dateEmbauche(LocalDate.of(2021, 4, 8))
                                                .servRattachement(Service.JURD)
                                                .build());
                                add(Employe.builder().nom("Mikey Mike").age(20)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(1560))
                                                .dateEmbauche(LocalDate.of(2020, 9, 13))
                                                .servRattachement(Service.INFO)
                                                .build());
                                add(Employe.builder().nom("Lisa Manoban").age(23)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(3995))
                                                .dateEmbauche(LocalDate.of(2020, 12, 21))
                                                .servRattachement(Service.RH)
                                                .build());
                                add(Employe.builder().nom("Eve Willow").age(29)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(3120))
                                                .dateEmbauche(LocalDate.of(2017, 3, 19))
                                                .servRattachement(Service.INFO)
                                                .build());
                                add(Employe.builder().nom("Jeremie ieu").age(39)
                                                .sexe(Sexe.HOMME)
                                                .salaire(new BigDecimal(2700))
                                                .dateEmbauche(LocalDate.of(2011, 6, 3))
                                                .servRattachement(Service.MARKET)
                                                .build());
                                add(Employe.builder().nom("Minatozaki Sana").age(25)
                                                .sexe(Sexe.FEMME)
                                                .salaire(new BigDecimal(2495))
                                                .dateEmbauche(LocalDate.of(2015, 1, 20))
                                                .servRattachement(Service.INFO)
                                                .build());
                        }
                };
        }

        /**
         * les employés (avec toutes leurs caractéristiques).
         */
        public static void requestA() {
                employes().stream()
                                .forEach(System.out::println);
        }

        /**
         * les employés de moins de 30 ans.
         */
        public static void requestB() {
                employes().stream()
                                .filter(Employe -> Employe.getAge() < 30)
                                .forEach(System.out::println);
        }

        /**
         * le nom des hommes.
         */
        public static void requestC() {
                employes().stream()
                                .filter(Employe -> Employe.getSexe() == Sexe.HOMME)
                                .map(Employe::getNom)
                                .forEach(System.out::println);
        }

        /**
         * le nom et le salaire trié par salaire décroissant.
         */
        public static void requestD() {
                employes().stream()
                                .sorted(Comparator.comparing(Employe::getSalaire)
                                                .reversed())
                                .map(employe -> String.format("Employe(nom=%s, salaire=%s)", employe.getNom(),
                                                employe.getSalaire()))
                                .forEach(System.out::println);
        }

        /**
         * la moyenne des salaires.
         */
        public static void requestE() {
                BigDecimal[] total = employes().stream()
                                .map(Employe::getSalaire)
                                .map(tt -> new BigDecimal[] {tt, BigDecimal.ONE })
                                .reduce((a, b) -> new BigDecimal[] {a[0].add(b[0]), a[1].add(BigDecimal.ONE) })
                                .get();
                System.out.println(total[0].divide(total[1], RoundingMode.HALF_UP));

        }

        /**
         * les employés regroupés selon leur sexe.
         */
        public static void requestF() {
                /*
                 * On regroupe dans une map les salariés selon leurs sexe (1ere clé : Femme,
                 * 2eme clé : Homme).
                 */
                Map<Sexe, List<Employe>> empS = employes().stream()
                                .collect(Collectors.groupingBy(Employe::getSexe));
                empS.entrySet()
                                .forEach(entry -> {
                                        System.out.println(entry.getKey());
                                        entry.getValue()
                                                        .forEach(System.out::println);
                                });
        }

        /**
         * la moyenne des salaires par sexe.
         */
        public static void requestG() {
                /*
                 * On regroupe dans une map les salariés selon leurs sexe (1ere clé : Femme,
                 * 2eme clé : Homme).
                 */
                Map<Sexe, List<Employe>> empS = employes().stream()
                                .collect(Collectors.groupingBy(Employe::getSexe));
                /*
                 * On calcule la moyenne de chaque entrée (donc de chaque sexe).
                 */
                empS.entrySet()
                                .forEach(entry -> {
                                        System.out.println(entry.getKey());
                                        BigDecimal[] total = entry.getValue().stream()
                                                        .map(Employe::getSalaire)
                                                        .map(tt -> new BigDecimal[] {tt, BigDecimal.ONE })
                                                        .reduce((a, b) -> new BigDecimal[] {a[0].add(b[0]),
                                                                        a[1].add(BigDecimal.ONE) })
                                                        .get();
                                        System.out.println(total[0].divide(total[1], RoundingMode.HALF_UP));

                                });
        }

        /**
         * le nom et la date d’embauche par services.
         */
        public static void requestH() {
                Map<Service, List<Employe>> emp = employes().stream()
                                .collect(Collectors.groupingBy(Employe::getServRattachement));
                emp.entrySet()
                                .forEach(entry -> {
                                        System.out.println(entry.getKey());
                                        entry.getValue().stream()
                                                        .map(e -> String.format("Employe(nom=%s, dateEmbauche=%s)",
                                                                        e.getNom(),
                                                                        e.getDateEmbauche()))
                                                        .forEach(System.out::println);
                                });
        }

        /**
         * Affichage du resultat de chaque requete.
         * @param args
         */
        public static void main(final String[] args) {
                System.out.println(
                                "\n\nRequete A : \'les employés avec toutes leurs caractéristiques\'");
                requestA();

                System.out.println(
                                "_________________________\n\nRequete B : \'les employés de moins de 30 ans\'");
                requestB();

                System.out.println(
                                "_________________________\n\nRequete C : \'le nom des hommes\'");
                requestC();

                System.out.println(
                                "_________________________\n\nRequete D : \'le nom et le salaire trié par salaire décroissant\'");
                requestD();

                System.out.println(
                                "_________________________\n\nRequete E : \'la moyenne des salaires'");
                requestE();

                System.out.println(
                                "_________________________\n\nRequete F : \'les employés regroupés selon leur sexe\'");
                requestF();

                System.out.println(
                                "_________________________\n\nRequete G : \'la moyenne des salaires par sexe\'");
                requestG();

                System.out.println(
                                "_________________________\n\nRequete H : \'le nom et la date d\'embauche par services\'");
                requestH();
        }
}
