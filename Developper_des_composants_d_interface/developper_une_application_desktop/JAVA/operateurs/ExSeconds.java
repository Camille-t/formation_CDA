package com.afpa;

import java.util.Scanner;

public class ExSeconds
{
    public static void main(String[] args)
    {
        int hours, minutes, seconds;

        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Conversion d'un nombre de secondes en HH:MM:SS. Il s'agit pour un nombre de secondes" +
                " entré au clavier d'en déduire, son expression en nombre d'heures de minutes et de secondes. ****");
        System.out.println("Saisissez le nombre de secondes que vous souhaitez convertir :");
        seconds = lectureClavier.nextInt();
        hours = seconds / 3600; // 1 heure = 60 minutes * 60 secondes = 3600 secondes
        seconds = seconds % 3600; // avec modulo on obtient le reste de la division entière de seconds / 3600
        minutes = seconds / 60; // 1 minute = 60 secondes
        seconds = seconds % 60;
        System.out.println("Résultat : " + hours + ":" + minutes + ":" + seconds);
    }
}
