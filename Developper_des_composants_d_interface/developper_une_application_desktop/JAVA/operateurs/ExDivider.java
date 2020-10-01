package com.afpa;

import java.util.Scanner;

public class ExDivider
{
    public static void main(String[] args)
    {
        double nb1; /* on utilise un type double car l'opérateur / entre 2 entiers correpond à la division entière
        et donne un résultat entier */
        double nb2;
        double division;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Diviseur : Modifier le programme précédent pour effectuer une division ****");
        System.out.println("Saisissez un premier nombre : ");
        nb1 = lectureClavier.nextDouble();
        System.out.println("Saisissez un deuxième nombre : ");
        nb2 = lectureClavier.nextDouble();
        if(nb2 != O)
        {
            division = nb1 / nb2;
            System.out.println(nb1 + " divisé par " + nb2 + " est égale à " + division);
        }
        else
        {
            System.out.println("Un nombre ne peut pas être divisé par 0.");
        }
    }
}
