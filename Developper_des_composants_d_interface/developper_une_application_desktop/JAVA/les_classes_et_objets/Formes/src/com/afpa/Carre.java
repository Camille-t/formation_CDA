package com.afpa;

public class Carre extends Forme {

    private float cote;

    public Carre(float c) {
        cote = c;
    }

    public float Aire() {
        return (float)Math.pow(cote, 2);
    }
}
