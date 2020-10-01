package com.afpa;

import java.util.Scanner;

public class ExAverageAndSum
{
    public static void main(String[] args)
    {
        float integer = 10; /* on initialise integer à n'importe quelle valeur différente de 0 afin d'être dans la
        condition pour entrer dans la boucle (cette valeur sera ensuite écrasée par l'entrée clavier) */
        float i = 0;
        float sum = 0;
        float average = 0;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Moyenne : V1.0 26/04/20 ****");
        while(integer != 0)
        {
            System.out.println("Saisissez un entier (ou saisissez 0 pour arrêter la saisie) : ");
            integer = lectureClavier.nextInt();
            /* lorsque l'utilisateur va saisir 0 pour terminer la saisie on ne veut pas continuer le calcul de la
            moyenne. Afin d'éviter que les calculs se fassent avec integer = 0 (et surtout avec i incrémenté)
            on ajoute une condition */
            if(integer != 0)
            {
                sum += integer;
                i++;
                average = sum / i;
            }
        }
        System.out.println("La somme des entiers saisis est égale à " + sum + " et la moyenne à " + average);
    }
}
