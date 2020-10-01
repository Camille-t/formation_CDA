package com.afpa;

import java.util.Scanner;

public class ExTriangleDrawing
{
    public static void main(String[] args)
    {
        int lines, i, j, k;
        int nbOfSpaces = 9;
        int nbOfStars = 1;
        char space = ' ';
        char star = '*';

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** dessin d'un triangle : V1.0 27/04/20 ****");
        System.out.println("Combien de lignes ?");
        lines = lectureClavier.nextInt();
        for(i = lines; i != 0; i--)
        {
            for(j = 0; j < nbOfSpaces; j++)
            {
                System.out.print(space);
            }
            nbOfSpaces -= 1;

            for(k = 0; k < nbOfStars; k++)
            {
                System.out.print(star);

            }
            nbOfStars += 2;

            System.out.println();
        }
    }
}
