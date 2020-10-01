package com.afpa;

import java.util.Scanner;

public class ExCircle // Classe qui est le composant de base d'une application Java
{
    final static double PI = 3.1416; /* déclaration et initialisation de la variable constante PI avec le mot-clé
    final. Le mot-clé static permet qu'elle soit accessible depuis plusieurs fonctions de la classe */

    public static void main(String[] args) // méthode/fonction qui est le point d'entrée de tout programme Java
    {
        // déclaration de mes variables au début du bloc de code (portée limitée à ce bloc)
        double rayon;
        double perimetre;
        double surface;

        Scanner lectureClavier = new Scanner(System.in); /* Classe Scanner permet à l'utilisateur de communiquer une
        entrée par l'intermédiaire du clavier */
        System.out.println("**** Périmètre et surface du Cercle (V1.0, 23/04/20) ****"); /* La méthode print() permet
        d'écrire du texte à l'écran en utilisant l'objet out de la classe System */
        System.out.println("Saisissez le rayon du cercle en cm : ");
        rayon = lectureClavier.nextDouble(); /* nextDouble() est une fonction de la classe Scanner qui donne l'ordre à
        l'ordinateur d'attendre une valeur. Ici on récupère cette valeur dans la variable rayon*/
        perimetre = 2 * PI * rayon;
        surface = PI * (rayon * rayon);
        System.out.println("Le périmètre du cercle est égal à : " + perimetre + " cm et sa surface est égale à : "
                + surface + "cm².");

    }
}
