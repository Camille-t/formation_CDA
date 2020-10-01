package com.afpa;

import java.util.Scanner;

public class ExMinAndMax
{
    public static void main(String[] args)
    {
        int integer = 10; /* on initialise integer à n'importe quelle valeur différente de 0 afin d'être dans la
        condition pour entrer dans la boucle (cette valeur sera ensuite écrasée par l'entrée clavier) */
        int min, max;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Mini et Maxi : V1.0 26/04/20 ****");
        System.out.println("Saisissez un entier (ou saisissez 0 pour arrêter la saisie) : ");
        min = lectureClavier.nextInt(); /* On affecte la valeur du premier entier saisi par l'utilisateur aux variables
        max et min */
        max = min;
        while(integer != 0)
        {
            System.out.println("Saisissez un entier (ou saisissez 0 pour arrêter la saisie) : ");
            integer = lectureClavier.nextInt();
            if(integer > max &&  integer != 0)
            {
                max = integer;
            }
            if(integer < min && integer != 0)
            {
                min = integer;
            }
        }
        System.out.println("La valeur mini que vous avez saisie est : " + min + " et la valeur maxi est : " + max);
    }
}
