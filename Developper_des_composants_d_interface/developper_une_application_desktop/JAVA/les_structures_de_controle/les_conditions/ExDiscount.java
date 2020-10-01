package com.afpa;

import java.util.Scanner;

public class ExDiscount
{
    public static void main(String[] args)
    {
        double unitPrice, totalPrice, priceToPay, shippingPrice, discount;
        int orderQuantity;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("**** Remise : V1.0 25/04/20 ****");
        System.out.println("Saisissez un prix unitaire :");
        unitPrice = lectureClavier.nextDouble();
        System.out.println("Saisissez la quantité commandée :");
        orderQuantity = lectureClavier.nextInt();

        totalPrice = unitPrice * orderQuantity;

        if(totalPrice > 500)
        {
            shippingPrice = 0;
        }
        else if(totalPrice >= 300)
        {
            shippingPrice = (totalPrice / 100) * 2;
        }
        else
        {
            shippingPrice = 6;
        }

        if(totalPrice >= 100)
        {
            if(totalPrice <= 200)
            {
                discount = (totalPrice / 100) * 5;
            }
            else
            {
                discount = (totalPrice / 100) * 10;
            }
        }
        else
        {
            discount = 0;
        }

        priceToPay = totalPrice + shippingPrice - discount;
        System.out.println("Le prix à payer est égal à " + priceToPay + "€");
    }
}
