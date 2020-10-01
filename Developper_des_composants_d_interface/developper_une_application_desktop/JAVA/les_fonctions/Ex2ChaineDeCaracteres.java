package com.afpa;

public class Ex2ChaineDeCaracteres {
    public static void main(String[] args) {
        System.out.println("**** Ecrire une fonction de concaténation de chaînes. Cette fonction se nommera concat, elle" +
                "doit prendre deux paramètres chaine1 et chaine2 de type String. Elle doit retourner le résultat de la" +
                "concaténation de chaine1 et chaine2. V1.0 30/04/20 ****");
        String resultat = (concat("Mon nom est ", "personne!"));
        System.out.println(resultat);
    }

    public static String concat(String chaine1, String chaine2) {
        return chaine1 + chaine2;
    }
}
