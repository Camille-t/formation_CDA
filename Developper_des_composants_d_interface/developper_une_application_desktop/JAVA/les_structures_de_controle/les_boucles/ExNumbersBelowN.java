package com.afpa;

import java.util.Scanner;

public class ExNumbersBelowN
{
    public static void main(String[] args)
    {
        int n, i;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Les entiers inférieur à N : V1.0 26/04/20 ****");
        System.out.println("Saisissez un nombre entier positif :");
        n = lectureClavier.nextInt();
        for(i = n-1 ; i >= 0 ; i--)
        {
            System.out.println(i);
        }
    }
}
