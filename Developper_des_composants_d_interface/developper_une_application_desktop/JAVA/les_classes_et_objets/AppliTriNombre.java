package com.afpa;

public class AppliTriNombre {
    public static void main(String[] args) {
        System.out.println("**** Créer la classe TriNombre. Cette classe comporte 2 données membre : 1 tableau de types " +
                "entiers et la taille du tableau. Cette classe contient 3 méthodes (fonctions membres) : " +
                "Fonction saisie () qui crée le tableau suivant la taille de ce dernier et qui demande à l’utilisateur " +
                "de remplir le tableau de nombres. Fonction tri() qui trie le tableau. Fonction affiche() qui affiche " +
                "le tableau. Créer un second fichier comme application qui crée 2 tableaux de tailles différentes, qui " +
                "les trie et qui les affiche. V1.0 03/05/20 ****");

        int nombreDeTableaux = 2;
        TriNombre[] tableau = new TriNombre[nombreDeTableaux];
        for (int i = 0 ; i <= nombreDeTableaux-1; i++) {
            tableau[i] = new TriNombre();
            tableau[i].saisie();
            tableau[i].tri();
            tableau[i].affiche();
        }
    }
}
