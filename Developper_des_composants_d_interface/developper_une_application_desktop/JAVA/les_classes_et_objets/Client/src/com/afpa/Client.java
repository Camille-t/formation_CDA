package com.afpa;

public class Client {

    // variables d'instance de la classe Client
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;

    // constructeur par défaut
    public Client() {

    }

    // constructeur permettant d'initialiser le nom, le prenom et la ville du Client
    public Client(String n, String p, String v) {
        nom = n;
        prenom = p;
        ville = v;
    }

    // accesseurs pour nos variables private
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // surcharge de la méthode toString()
    public String toString() {
        return "Prénom : " + this.prenom + ", Nom : " + this.nom + ", Adresse : " + this.adresse + ", Ville : " +getVille();
    }

}
