package com.afpa;

import java.util.Scanner;

public class ExContribution
{
    public static void main(String[] args)
    {
        String str;
        char married;
        int children, salary, contribution;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Participation : V1.0 26/04/20 ****");
        System.out.println("Etes-vous marié : [o/n] ?");
        str = lectureClavier.nextLine();
        married = str.charAt(0);
        if(married == 'o')
        {
            contribution = 25;
        }
        else
        {
            contribution = 20;
        }

        System.out.println("Combien d'enfants avez-vous? (0 pour aucun) : ");
        children = lectureClavier.nextInt();
        if(children != 0)
        {
            contribution += (children * 10);
        }

        System.out.println("Saisissez votre salaire mensuel :");
        salary = lectureClavier.nextInt();
        if(salary < 1200)
        {
            contribution += 10;
        }

        if(contribution > 50)
        {
            contribution = 50;
        }

        System.out.println("Vous avez droit à une participation employeur au taux de " + contribution + "%");
    }
}
