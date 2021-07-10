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
/*
Bearbeitet von Bella, Rahgawi  */

package com.se1_team20.Parkhaus.CHECKOUT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends CheckoutAuthenticationServlet {

    final private static long serialVersionUID = 1L;

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.setContentType("text/html");}

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    protected void handleEvent(String EVENT, String[] PARAMS) {}

}
