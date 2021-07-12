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
/*Bearbeitet von Lukas */
package com.se1_team20.Parkhaus.MANAGEMENT;

import com.se1_team20.Parkhaus.PARKHAUS.CarIF;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ManagementServlet")
public class ManagementServlet extends ManagementAuthenticationServlet {

    final private static long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        String[] requestParamString = request.getQueryString().split("=");
        String command              = requestParamString[0];
        String param                = requestParamString[1];

        if ("cmd".equals(command) && "customer_chart".equals(param)) {
            request.getRequestDispatcher("KundenChart.jsp").forward(request,response);
        }
        else if ("cmd".equals(command) && "income_chart".equals(param)) {
            request.getRequestDispatcher("IncomeChart.jsp").forward(request,response);
        }
        else if ("cmd".equals(command) && "revenue_chart_customer".equals(param)){
            request.getRequestDispatcher("AverageRevenueByCustomerTypeChart.jsp").forward(request, response);
        }
        else if ("cmd".equals(command) && "revenue_chart_vehicle".equals(param)){
            request.getRequestDispatcher("AverageRevenueByVehicleTypeChart.jsp").forward(request, response);
        }
    }


   public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String PARAM  = request.getParameter("username");
        final PrintWriter OUT = response.getWriter();

        //TODO: UNSAVE STUFF; SHOULD BE DELETED
        //* html  stuff to display the top part of the management view *//*
        OUT.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        OUT.write("<h2>Management Interface</h2>");
        OUT.write("<p style='color: purple; font-size: large;'>" + "Logged in as: " + PARAM + "</p>");
        OUT.write("</div></body></html>");
        OUT.close();
    }

    protected void handleBody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void handleEvent(String EVENT, String[] PARAMS) {}

}
