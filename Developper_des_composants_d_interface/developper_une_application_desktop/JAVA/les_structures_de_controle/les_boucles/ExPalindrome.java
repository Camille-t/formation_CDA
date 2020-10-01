package com.afpa;

import java.util.Scanner;

public class ExPalindrome
{
    public static boolean isPalindrome(String str)
    {
        int i = 0;
        int len;

        len = str.length(); // nombre de caractères dans la phrase
        while(len-- >= str.length()/2) /* permet de comparer le premier et le dernier caractères de la phrase,
        puis le deuxième et l'avant-dernier...*/
        {
            if(str.charAt(len) != str.charAt(i++))
                return false; // renvoie false si les deux caractères ne sont pas identiques
        }
        return true; // renvoie true si tous les caractères comparés sont identiques
    }

    public static void main(String[] args)
    {
        String str;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Palindrome : V1.0 27/04/20 ****");
        System.out.println("Entrez un mot ou une phrase :");
        str = lectureClavier.nextLine();
        str = str.toLowerCase(); // passe tous les caractères en minuscules
        str = str.replaceAll("\\W",""); // replace anything that isn't a word character (including punctuation)

        if(isPalindrome(str))
            System.out.println("C'est un palindrome !");
        else
            System.out.println("Ce n'est pas un palindrome.");
    }
}
