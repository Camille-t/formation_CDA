package com.afpa;

import java.util.Scanner;

public class ExNumberOfVowels
{
    public static void main(String[] args)
    {
        String word, letter;
        String str = "aeiouy";
        int i;
        int nbOfVowels = 0;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Nombre de voyelles : V1.0 27/04/20 ****");
        System.out.println("Saisissez un mot :");
        word = lectureClavier.nextLine(); // "bienvenue"
        for(i = 0; i < word.length(); i++) // word.length() = 9
        {
            letter = word.substring(i, i+1);
            if(str.indexOf(letter) != -1)
            {
                nbOfVowels++;
            }
        }
        System.out.println("Le mot \"" + word + "\" comporte " + nbOfVowels + " voyelles.");

    }
}
