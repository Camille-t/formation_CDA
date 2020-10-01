package com.afpa;

import java.util.Scanner;

public class ExNumbersBelowNSum
{
    public static void main(String[] args)
    {
        int n, i;
        int sum = 0;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** La somme des entiers inférieurs à N : V1.0 26/04/20 ****");
        System.out.println("Saisissez un nombre entier positif :");
        n = lectureClavier.nextInt();
        for(i = n-1 ; i > 0 ; i--)
        {
            sum += i;
        }
        System.out.println("La somme des entiers inférieurs à " + n + " est égale à " + sum);
    }
}
