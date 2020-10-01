package com.afpa;

import java.util.Scanner;

public class Exercice1
{
    public static void main(String[] args)
    {
        int arraySize, i, j, value;
        int[] tab;


        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Exercice 1 : écrivez un programme permettant de créer un tableau, dont la taille " +
                "est saisie au clavier. Ensuite l'utilisateur doit rentrer les différentes valeurs du tableau. " +
                "Puis votre programme doit afficher le contenu du tableau. ****");
        System.out.println("Saisissez la taille du tableau :");
        arraySize = lectureClavier.nextInt();
        tab = new int[arraySize];
        j = 1;
        for(i = 0; i < arraySize; i++)
        {
            System.out.println("Saisissez la valeur que vous souhaitez rentrer dans le champ " + j + " de votre tableau :");
            value = lectureClavier.nextInt();
            tab[i] = value;
            j++;
        }
        System.out.println("Voici le contenu de votre tableau :");
        for(i = 0; i < tab.length; i++)
        {
            System.out.println(tab[i]);
        }
    }
}
