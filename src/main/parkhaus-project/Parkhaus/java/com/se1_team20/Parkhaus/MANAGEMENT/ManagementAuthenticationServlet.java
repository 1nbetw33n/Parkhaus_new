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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ManagementAuthenticationServlet extends ParkingServlet {

    /* TODO: Create a jsp-File for creating the username and the password */

    final private static long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter OUT      = response.getWriter();
        String            username = request.getParameter("username");
        String            password = request.getParameter("password");
        if (!username.equals("Management") || !password.equals("easy-pass-word")) //LETS HACK THIS:D
        {
            OUT.write("<meta http-equiv='refresh' content='0;URL=ManagementAuthenticationView.jsp'>");//redirects after 3 seconds
            OUT.write("<script>alert('Invalid Credentials')</script>");
            OUT.close();
        }
        else { response.sendRedirect("ManagementView.jsp"); }
    }

}

       /* response.setContentType("text/html");
        final String[] PARAMS = request.getQueryString().split("=");
        final String CMD   = PARAMS[0];
        final String PARAM = PARAMS[1];
        final PrintWriter OUT = response.getWriter();

        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        RequestDispatcher requestDispatcherObject = null;

        *//* checks entered input for (null or "") *//*
        if (CMD == null || PARAM == null || "".equals(CMD) || "".equals(PARAM))
        {
            OUT.write("<p id='errMsg' style= color: red; font-size: larger: 'Enter USERNAME <u><b>AND</b></u> PASSWORD and try again</p>");
            requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
            requestDispatcherObject.include(request, response);
        }
        *//* entered input =/= (null or "") *//*
        else
        {
            System.out.println("Username?= " + CMD + ", Password?= " + PARAM);
            *//* in case username AND password are both correct*//*
            if ((CMD.equalsIgnoreCase("Management")) && (PARAM.equals("easy-pass-word")))
            {
                requestDispatcherObject = request.getRequestDispatcher("/ManagementServlet");
                requestDispatcherObject.forward(request, response);
            }
            *//* in case username and/or password are incorrect *//*
            else
            {
                OUT.write("<p id='errMsg style='color: red; font-size: larger;'<<b>Password and/or Username wrong! Try again</b></p>");
                requestDispatcherObject = request.getRequestDispatcher("/index.jsp");
                requestDispatcherObject.include(request, response);*/
           // }
       // }
       /*OUT.write("</div></body></html>");
        OUT.close();
    }

}*/
