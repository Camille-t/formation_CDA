package com.afpa;

import java.util.Scanner;

public class ExParity
{
    public static void main(String[] args)
    {
        short nb;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Parité. V1.0 25/04/20 ****");
        System.out.print("Saisissez un nombre :");
        nb = lectureClavier.nextShort();
        if (nb % 2 == 0)
        {
            System.out.println(nb + " est un nombre pair.");
        }
        else
        {
            System.out.println(nb + " est un nombre impair.");
        }
    }
}
