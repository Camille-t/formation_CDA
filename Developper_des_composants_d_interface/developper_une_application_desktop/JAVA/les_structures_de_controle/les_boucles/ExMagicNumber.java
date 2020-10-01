package com.afpa;

import java.util.Scanner;

import java.util.Random;

public class ExMagicNumber
{
    public static void main(String[] args)
    {
        int guessNumber = 0;
        String tooSmall = "Trop petit !";
        String tooBig = "Trop grand !";
        String result;
        Random aléatoire = new Random();
        int magicNumber = aléatoire.nextInt(100);
        magicNumber += 1;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Nombre magique : V1.0 27/04/20 ****");
        while(guessNumber != magicNumber)
        {
            System.out.println("Saisissez un nombre de 1 à 100 :");
            guessNumber = lectureClavier.nextInt();
            result = (guessNumber < magicNumber) ? tooSmall : tooBig;
            if(guessNumber != magicNumber)
            System.out.println(result);
        }
        System.out.println("Bravo ! Vous avez deviné le nombre magique : " + magicNumber);
    }
}
