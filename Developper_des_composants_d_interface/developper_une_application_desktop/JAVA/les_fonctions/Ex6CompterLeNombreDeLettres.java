package com.afpa;

public class Ex6CompterLeNombreDeLettres {

    public static void main(String[] args) {
        int nombre = compteLettre("combien de fois", "o");
        System.out.println(nombre);
    }

    public static int compteLettre(String phrase, String lettre) {
        int result = 0;
        for(int i = 0; i < phrase.length(); i++) {
            if(phrase.charAt(i) == lettre.charAt(0)) {
                result++;
            }
        }
        return result;
    }
}
