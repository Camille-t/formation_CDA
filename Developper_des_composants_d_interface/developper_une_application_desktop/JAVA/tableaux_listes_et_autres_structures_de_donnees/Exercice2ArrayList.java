package com.afpa;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercice2ArrayList
{
    public static void main(String[] args)
    {
        String firstName, firstNameToDelete;
        ArrayList<String> firstNamesList = new ArrayList<>();

        Scanner lectureClavier = new Scanner(System.in);

        System.out.println("**** Exercice 2 : On cherche dans un tableau contenant 20 prénoms, un prénom saisi " +
                "au clavier. Lorsque cet élément est trouvé, on l'élimine du tableau en décalant les cases qui le " +
                "suivent, et en mettant à blanc la dernière case. V1.0 29/04/20 ****");

        for (int i = 1; i < 21; i++)
        {
            System.out.println("Saisissez le prénom n° " + i + " à enregistrer dans le tableau : ");
            firstNamesList.add(lectureClavier.nextLine());
        }

        System.out.println("Voici les prénoms contenus dans votre tableau :");
        for(String i : firstNamesList)
            System.out.println(i);

        System.out.println("Quel prénom souhaitez-vous effacer : ");
        firstNameToDelete = lectureClavier.nextLine();
        for(int i = 0; i < firstNamesList.size(); i++) {
            if(firstNamesList.get(i).equals(firstNameToDelete))
                firstNamesList.remove(i);
        }

        System.out.println("Votre tableau contient maintenant les prénoms suivants :");
        for(String i : firstNamesList)
            System.out.println(i);
    }
}
