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

import com.se1_team20.Parkhaus.PARKHAUS.ParkingServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ManagementAuthenticationServlet extends ParkingServlet {

    final private static long serialVersionUID = 1L;


    /* TODO: Fix the authentication */
    /* TODO: Create a jsp-File for creating the username and and the password */
    /*
     right now the authentication is broken, because whatever you enter you will be redirected to ManagementServlet;
     also entering nothing and then hitting login button will result in redirection to ManagementServlet
     */
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        final String[] PARAMS = request.getQueryString().split("=");
        final String CMD   = PARAMS[0];
        final String PARAM = PARAMS[1];
        final PrintWriter OUT = response.getWriter();

        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        RequestDispatcher requestDispatcherObject = null;

        /* checks entered input for (null or "") */
        if (CMD == null || PARAM == null || "".equals(CMD) || "".equals(PARAM))
        {
            OUT.write("<p id='errMsg' style= color: red; font-size: larger: 'Enter USERNAME <u><b>AND</b></u> PASSWORD and try again</p>");
            requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
            requestDispatcherObject.include(request, response);
        }
        /* entered input =/= (null or "") */
        else
        {
            System.out.println("Username?= " + CMD + ", Password?= " + PARAM);
            /* in case username AND password are both correct*/
            if ((CMD.equalsIgnoreCase("Management")) && (PARAM.equals("easy-pass-word")))
            {
                requestDispatcherObject = request.getRequestDispatcher("/ManagementServlet");
                requestDispatcherObject.forward(request, response);
            }
            /* in case username and/or password are incorrect */
            else
            {
                OUT.write("<p id='errMsg style='color: red; font-size: larger;'<<b>Password and/or Username wrong! Try again</b></p>");
                requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
                requestDispatcherObject.include(request, response);
            }
        }
        OUT.write("</div></body></html>");
        OUT.close();
    }

}
