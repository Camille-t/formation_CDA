package com.afpa;

public class Avion extends Vehicule {
    public Avion() {

    }
    public Avion(String couleur, String marque, String modele, int vitesseMoyenne) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.vitesseMoyenne = vitesseMoyenne;
    }
     void marche() {
         System.out.println("Je vole dans les airs !");
     }
}
