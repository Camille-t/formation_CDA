package com.afpa;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercice1ArrayList
{
    public static void main(String[] args)
    {
        int ArrayListSize;
        String DataType;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Exercice 1 : écrivez un programme permettant de créer un tableau, dont la taille " +
                "est saisie au clavier. Ensuite l'utilisateur doit rentrer les différentes valeurs du tableau. " +
                "Puis votre programme doit afficher le contenu du tableau. V1.0 29/04/20 ****");

        System.out.println("Combien de données souhaitez-vous saisir dans le tableau ? ");
        ArrayListSize = lectureClavier.nextInt();

        System.out.println("Quel type de données souhaitez-vous saisir dans le tableau ? : [String|int|char|double|" +
                "boolean]");
        lectureClavier.nextLine(); // On vide la ligne avant d'en lire une autre
        DataType = lectureClavier.nextLine();
        switch (DataType) {
            case "String": {
                ArrayList<String> myList = new ArrayList<>();
                for (int i = 1; i < ArrayListSize + 1; i++) {
                    System.out.println(" Saisissez la donnée n° " + i + " :");
                    String value = lectureClavier.nextLine();
                    myList.add(value);
                }
                for(String i : myList)
                    System.out.println(i);
                break;
            }
            case "int": {
                ArrayList<Integer> myList = new ArrayList<>();
                for (int i = 1; i < ArrayListSize + 1; i++) {
                    System.out.println(" Saisissez la donnée n° " + i + " :");
                    int value = lectureClavier.nextInt();
                    myList.add(value);
                }
                for(int i : myList)
                    System.out.println(i);
                break;
            }
            case "char": {
                ArrayList<Character> myList = new ArrayList<>();
                for (int i = 1; i < ArrayListSize + 1; i++) {
                    System.out.println(" Saisissez la donnée n° " + i + " :");
                    String value = lectureClavier.nextLine();
                    char strToChar = value.charAt(0);
                    myList.add(strToChar);
                }
                for(char i : myList)
                    System.out.println(i);
                break;
            }
            case "double": {
                ArrayList<Double> myList = new ArrayList<>();
                for (int i = 1; i < ArrayListSize + 1; i++) {
                    System.out.println(" Saisissez la donnée n° " + i + " :");
                    double value = lectureClavier.nextDouble();
                    myList.add(value);
                }
                for(double i : myList)
                    System.out.println(i);
                break;
            }
            default: {
                ArrayList<Boolean> myList = new ArrayList<>();
                for (int i = 1; i < ArrayListSize + 1; i++) {
                    System.out.println(" Saisissez la donnée n° " + i + " : [true|false]");
                    boolean value = lectureClavier.nextBoolean();
                    myList.add(value);
                }
                for(boolean i : myList)
                    System.out.println(i);
                break;
            }
        }
    }
}
