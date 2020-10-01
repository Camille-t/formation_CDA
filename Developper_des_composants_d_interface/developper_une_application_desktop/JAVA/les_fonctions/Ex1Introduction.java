package com.afpa;

import java.util.Scanner;

public class Ex1Introduction {
    public static void main(String[] args) {

        double val1, val2;
        char op;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Reprendre le programme de calculette présenté dans le chapitre précédent et le modifier " +
                "pour intégrer des fonctions correspondant aux opérations effectuée. V1.0 30/04/20 ****");
        System.out.println("Choisissez un opérateur : [/|+|*|-]");
        String str = lectureClavier.nextLine();
        op = str.charAt(0);
        System.out.println("Choisissez un premier nombre :");
        val1 = lectureClavier.nextDouble();
        System.out.println("Choisissez un deuxième nombre :");
        val2 = lectureClavier.nextDouble();
        System.out.println(calcul(op, val1, val2));
    }

    public static double calcul(char operateur, double val1, double val2) {
        double resultat = 0.0;
        switch (operateur) {
            case '+':
                resultat = val1 + val2;
                break;
            case '-':
                resultat = val1 - val2;
                break;
            case '*':
                resultat = val1 * val2;
                break;
            case '/':
                if (val2 != 0)
                    resultat = val1 / val2;
                else {
                    System.out.println("Un nombre n'est pas divisible par zéro.");
                    System.exit(0);
                    break;
                }
            default:
                System.out.println("L'opérateur choisi n'a pas été reconnu par le système");
                System.exit(0);
        }
        return resultat;
    }
}
