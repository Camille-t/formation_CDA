package com.afpa;

import java.util.Scanner;

public class ExSwap
{
    public static void main(String[] args)
    {
        int nX;
        int nY;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Swap (V1.0, 23/04/2020) ****");
        System.out.println("Veuillez saisir un premier nombre (nX) : ");
        nX = lectureClavier.nextInt();
        System.out.println("Veuillez saisir un deuxième nombre (nY) : ");
        nY = lectureClavier.nextInt();
        System.out.println("Avant le swap nX = " + nX + " et nY = " + nY);
        nX = nX + nY;
        nY = nX - nY;
        nX = nX - nY;
        System.out.println("Après le swap nX = " + nX + " et nY = " + nY);
    }
}
