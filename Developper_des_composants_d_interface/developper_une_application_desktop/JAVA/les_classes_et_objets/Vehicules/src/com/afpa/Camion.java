package com.afpa;

public class Camion extends Vehicule {
    public Camion() {

    }
    public Camion(String couleur, String marque, String modele, int vitesseMoyenne) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.vitesseMoyenne = vitesseMoyenne;
    }
    void marche() {
        System.out.println("Je roule sur la route !");
    }
}
