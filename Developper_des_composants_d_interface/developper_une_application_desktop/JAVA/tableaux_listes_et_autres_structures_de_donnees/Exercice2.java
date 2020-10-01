package com.afpa;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        int i, len;
        String firstName;
        String[] firstNames = {"Audrey", "Aurélien", "Flavien", "Jérémy", "Laurent", "Melik", "Nouara", "Samuel",
                "Stéphane", "Camille", "Coralie", "Vincent", "Gaëtan", "Corentin", "Arnaud", "Valentin", "Adrien",
                "Guillaume", "Serhat", "Julien"};
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Exercice 2 : On cherche dans un tableau contenant 20 prénoms, un prénom saisi " +
                "au clavier. Lorsque cet élément est trouvé, on l'élimine du tableau en décalant les cases qui le " +
                "suivent, et en mettant à blanc la dernière case. ****");
        for (i = 0; i < firstNames.length; i++)
            System.out.println(firstNames[i]);
        System.out.println(" Saisissez un prénom à supprimer :");
        firstName = lectureClavier.nextLine();
        len = firstNames.length;
        for (i = 0; i < len; i++) {
            if (firstNames[i].equals(firstName) && i != len - 1) { // pour le cas où le prénom à supprimer est le dernier du tableau. Dans ce cas on le supprimer en dehors de la boucle
                do {
                    firstNames[i] = firstNames[i + 1];
                    i++;
                }
                while (i < len - 1);
                firstNames[len - 1] = " ";
                System.out.println(firstName + "a été supprimé.");
            }
        }
        System.out.println("Voici les prénoms présents dans le tableau :");
        for (i = 0; i < len; i++) {
            System.out.println(firstNames[i]);
        }
    }
}
