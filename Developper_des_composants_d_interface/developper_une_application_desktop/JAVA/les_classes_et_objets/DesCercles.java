package com.afpa;

public class DesCercles {
    public static void main(String[] args) {
        System.out.println("**** Dans un fichier nommé Cercles.java, créer la classe de même nom avec 1 variable rayon" +
                " comme donnée membre. Créer 2 fonctions membres calculSurface() et calculCirconference() qui retournent" +
                " le résultat sous forme de double.Créer un second fichier DesCercles.java comme application qui crée 2" +
                " objets Cercles de 10 et 45 cm de rayon et qui affiche leur Surface et leur Circonférence." +
                " V1.0 03/05/20 ****");

        /* On créé nos deux objets Cercles (instances de notre classe Cercles) à l'aide de l'opérateur new.
        Il nous sera ensuite possible d'accéder aux variables et aux méthodes de la classe Cercles à l'aide de l'opérateur
         "." */
        Cercles cercle1 = new Cercles(10);
        Cercles cercle2 = new Cercles(45);

        System.out.println("La surface du cerle de rayon 10 cm est égale à : " + cercle1.calculSurface() + " cm². Sa " +
                "circonférence est égale à : " + cercle1.calculCirconference() + " cm.");

        System.out.println("La surface du cerle de rayon 45 cm est égale à : " + cercle2.calculSurface() + " cm². Sa " +
                "circonférence est égale à : " + cercle2.calculCirconference() + " cm.");

    }
}
