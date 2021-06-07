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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends ParkingServlet {
    /*
     *  Checkout Servlet soll:
     *  Checkout Klasse verwenden um eine Oberfläche anzuzeigen (im Browser -> index.jsp ruft dieses dann auf)
     *  Die Berechnungen finden in Checkout statt -> keine Berechnungen im Servlet - Lukas
     *
     *  Über ein Textfeld soll man die Nr. des Autos angeben, welches dann verlässt
     *  Danach soll man wieder beim ParkhausServlet ankommen - Lukas
     *
     *  TODO: Checkout Klasse implementieren
     *  TODO: doPost() und doGet()
     *  TODO: Texteingabe?
     *  TODO: Zurück zum ParkhausServlet?
     */

    final private static long serialVersionUID = 1L;


    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }






}
