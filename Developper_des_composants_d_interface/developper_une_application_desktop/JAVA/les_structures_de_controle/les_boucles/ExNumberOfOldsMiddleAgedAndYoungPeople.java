package com.afpa;

import java.util.Scanner;

public class ExNumberOfOldsMiddleAgedAndYoungPeople
{
    public static void main(String[] args)
    {
        byte age = 10;
        byte old = 0;
        byte young = 0;
        byte middleAged = 0;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Nombre de jeunes, de moyens et de vieux : V1.0 27/04/20 ****");

        while(age < 100) /* La boucle while évalue la condition (être agé de moins de 100 ans) avant d'exécuter les
        instructions donc la saisie des âges s'arrêtera dés que l'utilisateur aura saisi un âge supérieur ou égal à 100 */
        {
            System.out.println("Saisissez un âge :");
            age = lectureClavier.nextByte();
            if(age < 20)
            {
                young++;
            }
            else if(age > 40)
            {
                old++;
            }
            else
            {
                middleAged++;
            }
        }
        System.out.println("Vous avez renseigné " + young + " jeunes, " + middleAged + " moyens et " + old + " vieux.");
    }
}
