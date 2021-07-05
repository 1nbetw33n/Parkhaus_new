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

package com.se1_team20.Parkhaus.MANAGEMENT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ManagementServlet")
public class ManagementServlet extends ManagementAuthenticationServlet{

    final private static long serialVersionUID = 1L;

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String PARAM  = request.getParameter("username");
        final PrintWriter OUT = response.getWriter();

        /* html  stuff to display the top part of the management view */
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        OUT.write("<h2>Management Interface</h2>");
        OUT.write("<p style='color: purple; font-size: large;'>" + "Logged in as: " + PARAM + "</p>");
        OUT.write("</div></body></html>");
        OUT.close();
    }

    protected void handleBody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    protected void handleEvent(String EVENT, String[] PARAMS)
    {
        //TODO: IMPLEMENT
    }

}
