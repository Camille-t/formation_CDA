package com.afpa;

import java.util.Scanner;

public class ExIntervalSum
{
    public static void main(String[] args)
    {
        int n1, n2, i;
        int sum = 0;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Somme d'un intervalle : V1.0 26/04/20 ****");
        System.out.println("Saisissez un premier nombre :");
        n1 = lectureClavier.nextInt();
        System.out.println("Saisissez un deuxième nombre :");
        n2 = lectureClavier.nextInt();
        if(n1 < n2)
        {
            for(i = n1 ; i <= n2; i++)
            {
                sum += i;
            }
        }
        else
        {
            for(i = n2 ; i <= n1 ; i++)
            {
                sum += i;
            }
        }
        System.out.println("La somme des entiers de " + n1 + " à " + n2 + " est égal à " + sum);
    }
}
