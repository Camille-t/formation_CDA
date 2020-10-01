package com.afpa;

import java.util.Scanner;

public class ExAverage
{
    public static void main(String[] args)
    {
        float guardedDuty;
        float writtenTest;
        float practicum;
        float average;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Calcul de la moyenne : il s'agit de calculer une moyenne sur la base de trois notes" +
                " sachant que : une note de devoir surveillé a un coefficient de 3 ; une note d'interrogation écrite " +
                " a un coefficient de 2 ; une note de travaux pratiques a un coefficient de 1. ****");
        System.out.println("Saisissez la note obtenue au devoir surveillé :");
        guardedDuty = lectureClavier.nextFloat();
        System.out.println("Saisissez la note obtenue à l'interrogation écrite :");
        writtenTest = lectureClavier.nextFloat();
        System.out.println("Saisissez la note obtenue en travaux pratiques :");
        practicum = lectureClavier.nextFloat();
        average = (guardedDuty*3 + writtenTest*2 + practicum) /6;
        System.out.println("La moyenne des 3 notes est égale à :" + average);
    }
}
