package com.afpa;

import java.util.Scanner;

public class ExAdder
{
    public static void main(String[] args)
    {
        double nb1;
        double nb2;
        double sum;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Additionneur : écrivez un programme qui demande deux nombres à l'utilisateur et " +
                "affiche la somme de ces deux nombres. ****");
        System.out.println("Saisissez un premier nombre : ");
        nb1 = lectureClavier.nextDouble();
        System.out.println("Saisissez un deuxième nombre : ");
        nb2 = lectureClavier.nextDouble();
        sum = nb1 + nb2;
        System.out.println("La somme de " + nb1 + " et " + nb2 + " est égale à : " +sum);
    }
}
