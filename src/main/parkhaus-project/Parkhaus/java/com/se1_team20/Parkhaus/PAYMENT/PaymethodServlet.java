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
/*Erstellt und bearbeitet von Preet*/

package com.se1_team20.Parkhaus.PAYMENT;

import com.se1_team20.Parkhaus.PARKHAUS.ParkingServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/PaymethodServlet")
public class PaymethodServlet extends ParkingServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         response.setContentType("text/html");

         request.getRequestDispatcher("Paymethod.jsp").forward(request,response);

    }


    @Override
    protected void handleEvent(String EVENT, String[] PARAMS) {

    }
}
