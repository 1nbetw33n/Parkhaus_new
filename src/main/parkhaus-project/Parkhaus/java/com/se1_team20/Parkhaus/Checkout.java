/*
 *  copyright (c) 2021 se1_team20.
 *  Planet Earth, Milky Way, Virgo Supercluster.
 *  All rights reserved.
 *
 *  part of team20:
 *
 *  1nbetw33n
 *  Masternuss
 *  Preet149
 *  Rahgawi
 *
 * This software is the confidential and proprietary information of
 * se1_team20. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * se1_team20.
 *
 */

package com.se1_team20.Parkhaus;
/*Preet: Sobald man auf ein Auto klickt, wird der counter gestoppt und eine Checkout Klasse wird instanziiert.

/* TODO: sollte die klasse eigene instanzvariablen haben? */

public class Checkout {

    private double price;    //fixed price per minutes
    private double bill;    //Payment to be payed by the driver before checking out.
    long bill_num;   // Ticketnumber
    private long duration;   // Parkdauer
    private String PaymentOption;
    //Saves the important information for every car.
    public Checkout(double price, long bill_Number, long duration){

        this.bill=price*duration;

        setPrice(this.price);

        this.bill_num=bill_Number;
        this.duration=duration;
    }

    /* TODO: sollte die checkout klasse in der lage sein, den preis zu verändern? */
    /* TODO: sollte die klasse checkout instanziierbar sein, oder eine helperklasse mit statischen methoden sein? */


    //Preet: Für Firmenkunde könnte der Preis auf 0 gesetzt werden.

    //Preet: Setting the fixed price per minutes.
    public void setPrice(double price){

          this.price=price;
    }

    public double getPrice(double total_amount){
        total_amount= duration * price;  // Berechnung von gesamtpreis des Parkdauers
        return total_amount;
    }

    //Saving the amount to be payed.
    public void setBill(double bill){

        this.bill=bill;
    }

    //Preet: Getting the bill.
    public double getBill(){

        return this.bill;
    }


    public void paymentOption(){        //Bezahlungsoptionen
         switch(PaymentOption){
             case "IBAN":
                 System.out.println("Please give your IBAN:");
            break;
             case "CreditCardOption":
                 System.out.println("PLease give your Cardnumber, the expiry Date and the security code of your Creditcard:");
                break;

         }


    }






}
