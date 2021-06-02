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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServletTest {

    CheckoutServlet checkoutServlet = new CheckoutServlet();
    ParkhausServlet level1Servlet = new Level1Servlet() {

    Checkout checkout = new Checkout(3,55,10);
    double total_amount = 10;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("A display of the price is implemented in the Servlet")
    void showTicketPriceTest() {
        // CheckoutServlet should show the Current Price
        // Calculation is used in Checkout-Class
        // Method needs to be implemented
        assertEquals(total_amount, checkoutServlet);
    }

    @Test
    @DisplayName("")
    void carLeftParkausTest() {
        // CheckoutServlet should remove one Car from Parkhaus (or we use Parkhaus directly for this)
        // Remove is implemented in ParkhausServlet
        // CheckoutServlet uses ParkhausServlet -> Maybe implement Controller to gain Abstraction (up to you)
        // Very unsure how to implement this, because we cant work with Httprequest i think... We could outsource this into a function like cars()
        assertEquals(1,level1Servlet.cars());
        checkoutServlet.checkout();
        assertEquals(0,level1Servlet.cars());


    }

    @Test
    @DisplayName("A Default-Ticket (time) is being calculated in Checkout and used in the CheckoutServlet.")
    void defaultTicketTest() {
        // CheckoutTicket needs to be equal in both classes (implement class into servlet)
        // Method of Servlet is not yet implemented
        // CheckoutTicket isnt finished, but the calculation should not matter here
        assertEquals(checkout.getPrice(total_amount), checkoutServlet);
    }



    @Test
    @DisplayName("The Customer receives a Message, that they successfully paid their ticket.")
    void defaultTicketSuccessfulTest() {
        // Message, that Customer has successfully paid the ticket
        // Method of Servlet is not yet implemented
        assertEquals("Payment was successful!", checkoutServlet);
    }

    @Test
    @DisplayName("The Customer receives a Message, that they havent paid the correct amount.")
    void defaultTicketUnsuccessfulTest() {
        // Message, that Customer has not successfully paid the ticket
        // Method of Servlet is not yet implemented
        assertEquals("Payment was unsuccessful!", checkoutServlet);
    }

    @AfterEach
    void tearDown() {
    }
}