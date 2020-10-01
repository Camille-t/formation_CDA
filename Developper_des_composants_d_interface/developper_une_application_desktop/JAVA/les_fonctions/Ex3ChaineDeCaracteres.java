package com.afpa;

import java.util.Scanner;

public class Ex3ChaineDeCaracteres {
    public static void main(String[] args) {
        String str;

        System.out.println("**** Ecrire une fonction qui affiche le nombre de mots d'une phrase. Cette fonction se" +
                "nommera compteMot. Elle prendra en paramètre une chaîne de caractères. Elle retourne le nombre de mots" +
                "présents dans la phrase. V1.0 01/05/20 ****");
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Saisissez une phrase :");
        str = lectureClavier.nextLine();
        System.out.println("Cette phrase compte : " + compteMot(str) + " mots.");

    }

    public static Integer compteMot(String phrase) {
        int resultat = 1;
        for (int i = 0; i < phrase.length(); i++) {
            if(phrase.charAt(i) == ' ') {
                resultat++;
            }
        }
        return resultat;
    }
}

