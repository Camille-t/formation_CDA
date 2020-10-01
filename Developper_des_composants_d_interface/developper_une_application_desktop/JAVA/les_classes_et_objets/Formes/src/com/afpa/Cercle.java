package com.afpa;

public class Cercle extends Forme {

    private float rayon;

    public Cercle(float r) {
        rayon = r;
    }

    public float Aire() {
        return (float)(Math.PI * Math.pow(rayon, 2));
    }
}
