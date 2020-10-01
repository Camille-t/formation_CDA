package com.afpa;

public class Bateau extends Vehicule {
    public Bateau() {

    }
    public Bateau(String couleur, String marque, String modele, int vitesseMoyenne) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.vitesseMoyenne = vitesseMoyenne;
    }
    void marche() {
        System.out.println("Je flotte sur la mer !");
    }
}
