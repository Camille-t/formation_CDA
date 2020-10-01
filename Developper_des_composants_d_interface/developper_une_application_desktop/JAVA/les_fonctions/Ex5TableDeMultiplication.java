package com.afpa;

import java.util.Scanner;

public class Ex5TableDeMultiplication {

    public static void main(String[] args) {
        int table;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Ecrivez une fonction qui affiche une table de multiplication. Votre fonction doit " +
                "prendre un paramètre qui permet d'indiquer quelle table afficher. V1.0 01/05/20 ****");
        System.out.println("Saisissez le nombre de la table de multiplication que vous souhaitez afficher :");
        table = lectureClavier.nextInt();
        tableMultiplication(table);
    }

    public static void tableMultiplication(int n) {
        int multiple = 0;
        for(int i = 1; i <= 10; i++)
        {
            multiple = i * n;
            System.out.println(i + " x " + n + " = " + multiple);
        }
    }
}
