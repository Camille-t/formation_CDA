package com.afpa;

public abstract class Vehicule {

    protected String couleur;
    protected String marque;
    protected String modele;
    protected int vitesseMoyenne;

    abstract void marche();

    public String toString() {
        return "Je suis un objet de la " + this.getClass() + " je suis de la marque " + this.marque +
                " du modèle " + this.modele + " et je roule à " + this.vitesseMoyenne + " km/h";
    }
}
