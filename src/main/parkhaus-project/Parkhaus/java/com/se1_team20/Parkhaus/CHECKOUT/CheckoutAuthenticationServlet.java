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
/*
1nbetw33n
29.Jun.2021
*/

import com.se1_team20.Parkhaus.PARKHAUS.ParkingServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class CheckoutAuthenticationServlet extends ParkingServlet {

    final private static long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        final String         CARNR             = request.getParameter("carNrEnter");
        final PrintWriter OUT                     = response.getWriter();
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        if (!CARNR.equals("12345")) { handleInvalid(OUT);}
        else                                           { handleSuccess(CARNR, response, request);}
        OUT.write("</div></body></html>");
        OUT.close();
    }

    private void handleInvalid(final PrintWriter OUT)
    {
        OUT.write("<meta http-equiv='refresh' content='0;URL=CheckoutAuthenticationView.jsp'>");//redirects instantly after pressing ok
        OUT.write("<script>alert('Invalid Credentials')</script>");
    }

    private void handleSuccess(final String EVENT, HttpServletResponse response, final HttpServletRequest request) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CheckoutView.jsp");
        dispatcher.forward(request, response);
        getContext().setAttribute("carNr", EVENT);
    }


}
