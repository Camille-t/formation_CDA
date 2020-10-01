package com.afpa;

import java.util.Scanner;

public class ExTemperatureConversion
{
    public static void main(String[] args)
    {
        double f;
        double c;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** En utilisant la formule C = (5/9)(F-32) écrire un programme qui lit une température " +
                "exprimée en degrés Fahrenheit et affiche sa valeur en degrés Celsius ****");
        System.out.println("Saisissez une température en degrés Fahrenheit :");
        f = lectureClavier.nextDouble();
        c = (5.00/9.00)*(f-32.00);
        System.out.println(f + " degrés Fahrenheit est égal à " + c + " degrés Celsius.");
    }
}
