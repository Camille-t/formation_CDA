package com.afpa;

public class Main {

    public static void main(String[] args) {
	Avion a = new Avion("blanc", "Airbus", "A330", 1000);
	a.marche();
	System.out.println(a.toString());
	Velo v = new Velo("rouge", "Rockrider", "RR340", 25);
	v.marche();
	System.out.println(v.toString());
	Bateau b = new Bateau("vert", "Black Pepper", "Code 1 Foiler", 37);
	b.marche();
	System.out.println(b.toString());
	Camion c = new Camion("gris", "Iveco", "Eco Daily", 90);
	c.marche();
	System.out.println(c.toString());
    }

}
