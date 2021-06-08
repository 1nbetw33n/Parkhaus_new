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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagementAuthenticationServlet extends ParkingServlet{

    final private static long serialVersionUID = 1L;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        final String[] PARAMS = request.getQueryString()
                                       .split("=");
        final String CMD   = PARAMS[0];
        final String PARAM = PARAMS[1];

        final PrintWriter OUT = response.getWriter();
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");

        RequestDispatcher requestDispatcherObject = null;
        if (CMD == null || PARAM == null || "".equals(CMD) || "".equals(PARAM))
        {
            OUT.write("<p id='errMsg' style= color: red; font-size: larger: 'Enter USERNAME & PASSWORD and try again</p>");
            requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
            requestDispatcherObject.include(request, response);
        } else
        {
            System.out.println("Username?= " + CMD + ", Password?= " + PARAM);

            if ((CMD.equalsIgnoreCase("mana-gem-ent")) && (PARAM.equals("easy-pass-word-ABC-01")))
            {
                requestDispatcherObject = request.getRequestDispatcher("/ManagementServlet");
                requestDispatcherObject.forward(request, response);
            } else
            {
                OUT.write("<p id='errMsg style='color: red; font-size: larger;'<YOU DONT HAVE ACCESS PERMISSION!</p>");
                requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
                requestDispatcherObject.include(request, response);
            }
        }
        OUT.write("</div></body></html>");
        OUT.close();
    }

}
