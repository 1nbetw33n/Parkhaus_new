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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ParkingServlet extends HttpServlet implements ParkingServletable{

    /* default implementation */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    /* default implementation */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { handleRequest(request, response); }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /* default implementation */
    final public ServletContext getContext() { return getServletConfig().getServletContext();}

    /* default implementation */
    final public void destroy(){
        System.out.println("Server annihilated. Nothing shall remain of this servant");
    }


}
