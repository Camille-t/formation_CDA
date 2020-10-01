package com.afpa;

public class Cercles {
    // on crée une classe Cercles et ses variables membre
    final static double PI = 3.1416;
    private int rayon; // on utilise getters et setters afin de pouvoir accéder à/modifier notre variable rayon de type private

    public Cercles(int rayon) { // notre constructeur pour l'objet Cercles (définit les données que l'on va lui attribuer, en l'occurence un rayon)
        this.rayon = rayon;
    }

    public float getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    // On crée nos deux méthodes pour calculer surface et circonférence d'un cercle
    public double calculSurface() {
        return PI * Math.pow(this.rayon, 2);
    }

    public double calculCirconference() {
        return 2 * PI * this.rayon;
    }

}
