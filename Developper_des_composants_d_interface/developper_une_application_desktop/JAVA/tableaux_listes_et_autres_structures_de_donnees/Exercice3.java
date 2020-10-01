package com.afpa;

public class Exercice3 {
    public static void main(String[] args) {
        int[] tab = {6, 2, 8, 4, 7, 9, 3, 5, 1};
        int temp;
        int len = tab.length;
        System.out.println("**** Exercice 3 : Tri d'un tableau. Ecrire un programme qui permet de trier un tableau en " +
                "utilisant le tri à bulles ****");
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
            if (tab[j] > tab[j + 1]) {
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
            }
        System.out.println("Voici les valeurs du tableau triées par ordre croissant : ");
        for (int i : tab) {
            System.out.println(i);
        }
    }
}
