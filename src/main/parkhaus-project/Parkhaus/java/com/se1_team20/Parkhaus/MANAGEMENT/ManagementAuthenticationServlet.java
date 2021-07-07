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

    /* TODO: Create a jsp-File for creating the username and the password */

    final private static long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String            USERNAME   = request.getParameter("username");
        final String            PASSWORD  = request.getParameter("password");
        final PrintWriter   OUT              = response.getWriter();
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        RequestDispatcher dispatcher    = null;
        if (!USERNAME.equals("Management") || !PASSWORD.equals("easy-pass-word")) //LETS HACK THIS:D
        {
            OUT.write("<meta http-equiv='refresh' content='0;URL=ManagementAuthenticationView.jsp'>");//redirects after 0 seconds
            OUT.write("<script>alert('Invalid Credentials')</script>");
        }
        else
        {
            request.getRequestDispatcher("ManagementView.jsp").forward(request, response);
        }
        OUT.write("</div></body></html>");
        OUT.close();
    }

}
