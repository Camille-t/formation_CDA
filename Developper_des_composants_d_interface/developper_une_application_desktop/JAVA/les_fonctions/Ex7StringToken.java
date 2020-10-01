package com.afpa;

public class Ex7StringToken {
    public static void main(String[] args) {
        String str1, resultat;
        str1 = "robert;dupont;amiens;80000";
        resultat = strtok(str1, ";", 3);
        System.out.println(resultat);
    }

    public static String strtok(String str1, String str2, int n) {
        String tab[] = str1.split(str2);
        return tab[n-1];
    }
}
