package com.afpa;

import java.util.Scanner;

public class ExAge
{
    final static int anneeActuelle = 2020;

    public static void main(String[] args)
    {
        int anneeDeNaissance, age;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Age. V1.0 25/04/20 ****");
        System.out.print("Saisissez votre année de naissance :");
        anneeDeNaissance = lectureClavier.nextShort();
        age = anneeActuelle - anneeDeNaissance;
        if(age>=18)
        {
            System.out.print("En 2020 vous avez eu " + age + ", vous êtiez donc majeur.");
        }
        else
        {
            System.out.print("En 2020 vous avez eu " + age + ", vous êtiez donc mineur.");
        }
    }
}
