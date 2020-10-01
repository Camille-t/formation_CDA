package com.afpa;

import java.util.Scanner;

public class ExCalculator
{
    public static void main(String[] args)
    {
        float nb1, nb2, result;
        String str;
        char operator;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Calculette : V1.0 25/04/20 ****");
        System.out.println("Veuillez saisir un premier nombre entier :");
        nb1 = lectureClavier.nextFloat();
        System.out.println("Veuillez saisir un deuxième nombre entier :");
        nb2 = lectureClavier.nextFloat();
        System.out.println("Veuillez maintenant saisir un opérateur : +, -, * ou /");
        lectureClavier.nextLine(); // On vide la ligne avant d'en lire une autre
        str = lectureClavier.nextLine(); /* on récupère une chaîne de caractères (on ne peut pas récupérer une variable
        de type caractère avec la classe Scanner) puis on utilise la méthode charAt(0) de l'objet String pour récupérer
        le premier caractère */
        operator = str.charAt(0);
        switch (operator)
        {
            case '+':
                result = nb1 + nb2;
                System.out.println((int)nb1 + "+" + (int)nb2 + "=" + (int)result);
                break;
            case '-':
                result = nb1 - nb2;
                System.out.println((int)nb1 + "-" + (int)nb2 + "=" + (int)result);
                break;
            case '*':
                result = nb1 * nb2;
                System.out.println((int)nb1 + "*" + (int)nb2 + "=" + (int)result);
                break;
            case '/':
                if(nb2 != 0){
                    result = nb1 / nb2;
                    System.out.println((int)nb1 + "/" + (int)nb2 + "=" + result);
                }else{
                    System.out.println("Un nombre n'est pas divisible par 0.");
                }
                break;
            default:
                System.out.println("L'opérateur que vous avez choisi n'est pas reconnu");
        }
    }
}
