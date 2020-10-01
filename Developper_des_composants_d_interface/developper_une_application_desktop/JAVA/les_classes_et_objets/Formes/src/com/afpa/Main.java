package com.afpa;

public class Main {

    public static void main(String[] args) {

        // tableau d'objets Forme (dc y compris les classes héritées de la classe Forme)
        // déclaration d'objets avec paramètres (possible grâce aux constructeurs d'initialisation des différentes classes filles)
        Forme[] tableau = { new Carre(2), new Cercle(3), new Carre(5), new Triangle(4, 3) };

        float s = 0;

        /* boucle for qui permet de récupérer les différents objets (ici fo) de notre tableau d'objets Forme
         ces objets peuvent être de n'importe quel type hérité de la classe Form (covariance des variables)
         fo.Aire() nous permet de récupérer l'aire de chacun de ces objets (avec leurs différentes méthodes propres)
         s additionne et stocke le total de l'aire de chacun des objets
         */
        for(Forme fo : tableau) {
            s += fo.Aire();
        }
        System.out.println(s);
    }
}
