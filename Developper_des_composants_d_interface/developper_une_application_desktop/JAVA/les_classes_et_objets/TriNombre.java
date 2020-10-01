package com.afpa;

import java.util.Arrays;
import java.util.Scanner;

public class TriNombre {
    private int taille;
    private int[] tableau;

    public void saisie() {
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Saisissez la taille du tableau que vous souhaitez créer (le nombre de données qu'il contiendra) :");
        this.taille = lectureClavier.nextInt();
        this.tableau = new int[this.taille];

        for(int i = 0; i < this.taille; i++) {
            System.out.println("Saisissez le nombre à insérer dans le tableau à la position n° " +(i+1));
            this.tableau[i] = lectureClavier.nextInt();
        }
    }

    public void tri() {
        Arrays.sort(this.tableau);

    }

    public void affiche() {
        for(int i = 0; i < this.taille; i++) {
            System.out.println(this.tableau[i]);
        }
    }
}
