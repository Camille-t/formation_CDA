package com.afpa;

public class Triangle extends Forme { // Notre classe Triangle est une classe fille de la classe Forme

    // attributs de notre objet Triangle : variables d'instance (private afin de les rendre inaccessibles en dehors de cette classe)
    private float base;
    private float hauteur;

    public Triangle(float b, float h) { // Constructeur de notre objet (méthode qui permettra d'initialiser un objet Triangle avec des paramètres)
        base = b;
        hauteur = h;
    }

    // accesseurs qui nous permettront d'accéder à nos attributs en dehors de la classe (pas utilisé ds cet ex)
    public float getBase() {
        return base;
    }

    public float getHauteur() {
        return hauteur;
    }

    // mutateurs (type void car ne retournent pas de valeurs (mise à jour)) (pas utilisé dans cet ex)
    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public void setBase(float base) {
        this.base = base;
    }

    // notre méthode public qui retourne la valeur de la surface d'un objet Triangle
    public float Aire() {
        return base*hauteur/2;
    }
}
