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
KLasse bearbeitet von Bella,Rahgawi
*/

import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import com.se1_team20.Parkhaus.PARKHAUS.ParkingServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class CheckoutAuthenticationServlet extends ParkingServlet {

    final private static long serialVersionUID = 1L;

    //Bearbeitet von Bella
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        final String enteredLicensePlate  = request.getParameter("entered_license_plate");
        final List<CarIF> CARS               = (ArrayList<CarIF>) request.getServletContext().getAttribute("former-cars" + "Level1");
        final PrintWriter OUT                   = response.getWriter();
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        if (CheckoutModel.filterByLicensePlate(CARS, enteredLicensePlate) == null) {this.handleInvalid(OUT);}
        else{this.handleSuccess(response, request, CheckoutModel.filterByLicensePlate(CARS, enteredLicensePlate)); }
        OUT.write("</div></body></html>");
        OUT.close();
    }

    //Bearbeitet von Rahgawi
    private void handleInvalid(final PrintWriter OUT) {
        OUT.write("<meta http-equiv='refresh' content='0;URL=CheckoutAuthenticationView.jsp'>");//redirects instantly after pressing ok
        OUT.write("<script>alert('Invalid Credentials')</script>");
    }

    //Bearbeitet von Rahgawi
    private void handleSuccess(HttpServletResponse response, final HttpServletRequest request, final CarIF CAR) throws ServletException, IOException {
        getContext().setAttribute("checked_out_car", CAR);
        request.getRequestDispatcher("CheckoutView.jsp").forward(request, response);
    }


}
