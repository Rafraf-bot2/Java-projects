# Simulateur de requetes
Le but de cette exercice est d'exprimer un ensemble de requêtes en utilisant la bibliothèque `stream`.  
***
Nous avons une classe `Employe` possedant les attributs :  
- Nom (`String`)
- Age (`int`), 
- Sexe (`enum`), 
- Salaire (`BigDecimal`),
- Date d'embauche (`LocalDate`)  
- Service de rattachement (`Service`).  
⚠️Un service comporte un nom (`String`) et une adresse (`String`).  

Les requetes suivantes sont implementées (affichage à chaque requete) :
- Les employés (avec toutes leurs caractéristiques)
- Les employés de moins de 30 ans
- Le nom des hommes
- Le nom et le salaire trié par salaire décroissant
- La moyenne des salaires
- Les employés regroupés selon leur sexe
- La moyenne des salaires par sexe
- Le nom et la date d'embauche par services