package com.afpa;

import java.util.Scanner;

public class ExPrimeNumber
{
    public static void main(String[] args)
    {
        // Un nombre est premier lorsqu'il n'a pas d'autre diviseur que 1 et lui-même
        int nbr;
        int divider = 2;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Un nombre est-il premier : V1.0 27/04/20 ****");
        System.out.println("Saisissez un nombre :");
        nbr = lectureClavier.nextInt();
        while(divider < nbr)
        {
            if((nbr % divider) == 0) // si le nombre saisi % 2 = 0 c'est qu'il est divisible donc il n'est pas premier
                divider = nbr + 1; // on "force" la sortie de la boucle en rendant fausse la condition du while
            else
                divider++;
        }
        // si le nombre n'est pas premier, on a modifié la condition dans le if précédent
        if(divider > nbr)
            System.out.println(nbr + " n'est pas un nombre premier.");
        else
            System.out.println(nbr + " est un nombre premier.");
    }
}
