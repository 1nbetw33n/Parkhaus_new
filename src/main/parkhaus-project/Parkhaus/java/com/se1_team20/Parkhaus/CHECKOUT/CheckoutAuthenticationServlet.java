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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String         TICKETID             = request.getParameter("username");
        final PrintWriter OUT                     = response.getWriter();
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        RequestDispatcher dispatcher = null;
        if (!TICKETID.equals("12345")) //LETS HACK THIS:D
        {
            OUT.write("<meta http-equiv='refresh' content='0;URL=CheckoutAuthenticationView.jsp'>");//redirects after 3 seconds
            OUT.write("<script>alert('Invalid Credentials')</script>");
        }
        else
        {
            dispatcher = request.getRequestDispatcher("CheckoutViewJSP.jsp");
            dispatcher.forward(request, response);
        }
        OUT.write("</div></body></html>");
        OUT.close();
    }
}
