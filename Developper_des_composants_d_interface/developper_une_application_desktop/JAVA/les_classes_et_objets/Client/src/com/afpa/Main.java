package com.afpa;

public class Main {

    public static void main(String[] args) {
        /* On crée un tableau de 4 objets Client.
        On crée 3 tableaux de String contenant les noms, prénoms et adresses de nos clients.
        Grâce à une boucle nous allons créer 4 objets clients en récupérant les valeurs stockées dans nos tableaux de
        String et initialiser nos objets Ville grâce à notre constructeur permettant (d'initialiser le nom, le prénom
        et la ville du client).
         */
        Client[] tableau = new Client[4];
        String[] tabNom = {"Paul", "White", "Claypool", "Thunders"};
        String[] tabPrenom = {"Weller", "Jack", "Les", "Johnny"};
        String[] tabVille = {"Londres", "Detroit", "San Francisco", "New York"};
        for (int i = 0; i < 4; i++) {
            Client cli = new Client(tabNom[i], tabPrenom[i], tabVille[i]);
            tableau[i] = cli;
        }

        // on utilise notre setter pour initialiser l'adresse du premier objet Client de notre tableau d'objets Client
        tableau[0].setAdresse("Baker Street");

        // on utilise une boucle pour parcourir les éléments de notre tableau d'objet et leur appliquer la méthode surchargée toString()
        for (Client cli : tableau)
            System.out.println(cli.toString());
    }
}
