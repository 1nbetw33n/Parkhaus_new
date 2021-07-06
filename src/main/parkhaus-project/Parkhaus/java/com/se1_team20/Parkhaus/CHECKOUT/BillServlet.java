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

package com.se1_team20.Parkhaus.CHECKOUT;
import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import com.se1_team20.Parkhaus.PARKHAUS.ParkhausServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BillServlet")
public class BillServlet extends CheckoutServlet {

    private static final Long serialVersionUID = 1L;

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        ServletContext application = getContext();

      //  if ("cmd".equals(command) && "view".equals(param)) {
       //     getContext().setAttribute("bill" ,handleViewBill(licensePlate)); //statt License muss hier das Kennzeichen des Autos hin
        }





   // final public CarIF handleViewBill(String licensePlate) {

    //return cars().stream().filter(x -> x.nr.equals(licensePlate));



    }








