package com.afpa;

import java.util.Scanner;

public class ExMultiples
{
    public static void main(String[] args)
    {
        int n, x, i, multiple;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Multiples : V1.0 27/04/20 ****");
        System.out.println("Saisissez un nombre entier :");
        x = lectureClavier.nextInt();
        System.out.println("Saisissez un nombre entier :");
        n = lectureClavier.nextInt();
        for(i = 1; i <= n; i++)
        {
            multiple = i * x;
            System.out.println(i + "x" + x + "=" + multiple);
        }
    }
}
