package com.afpa;

import java.util.Scanner;

public class Ex4Fibonacci {

    public static void main(String[] args) {
        int c;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Ecrire un programme qui affiche les premiers termes de la suite Fibonacci. V1.1 01/05/20 ****");
        System.out.println("Saisissez le nombre de termes de la suite de Fibonacci que vous souhaitez voir afficher : ");
        c = lectureClavier.nextInt();
        for (int i = 1; i <= c; i++) {
            System.out.println(fibonnaci(i));
        }
    }

    public static long fibonnaci(int n) {
        /* u0 = u1 = 1,
        un = un-1 + un-2 pour n > 1 */
        if (n <= 1)
            return 1;
        else
            return fibonnaci(n - 1) + fibonnaci(n - 2);
    }
}

/*
ex : n = 4
fibonacci(4) -> fibonacci(3) + fibonacci(2)
       -> (fibonacci(2) + fibonacci(1)) + fibonacci(2)
       -> ((fibonacci(1) + fibonacci(1)) + fibonacci(1)) + fibonacci(2)
       -> ((1 + fibonacci(1)) + fibonacci(1)) + fibonacci(2)
       -> ((1 + 1) + fibonacci(1)) + fibonacci(2)
       -> (2 + fibonacci(1)) + fibonacci(2)
       -> (2 + 1) + fibonacci(2)
       -> 3 + fibonacci(2)
       -> 3 + (fibonacci(1) + fibonacci(1))
       -> 3 + (1 + fibonacci(1))
       -> 3 + (1 + 1)
       -> 3 + 2
       -> 5
 */


