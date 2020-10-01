package com.afpa;

import java.util.Scanner;

public class ExAscii
{
    public static void main(String[] args)
    {
        int unicode;
        // Une constante char représente un caractère Unicode unique
        // Les constantes caractères possèdent une représentation décimale
        /* On effectue un transtypage d'une variable int représentant un entier(décimal) vers une variable de type char
        pour afficher le caractère correspondant */

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** ASCII : écrire un programme qui saisit un code Unicode en décimal et affiche le " +
                "caractère correspondant. Ex: la saisie de l'entier 65 donne le caractère 'A' ****");
        System.out.println("Saisissez un code Unicode en décimal :");
        unicode = lectureClavier.nextInt();
        char code = (char) unicode;
        System.out.println("L'unicode " + unicode + " donne le caractère " + code);
    }
}
