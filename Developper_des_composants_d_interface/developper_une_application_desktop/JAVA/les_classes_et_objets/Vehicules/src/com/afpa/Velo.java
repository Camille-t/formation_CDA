package com.afpa;

public class Velo extends Vehicule {
    public Velo() {

    }
    public Velo(String couleur, String marque, String modele, int vitesseMoyenne) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.vitesseMoyenne = vitesseMoyenne;
    }
    void marche() {
        System.out.println("Je roule partout !");
    }
}
