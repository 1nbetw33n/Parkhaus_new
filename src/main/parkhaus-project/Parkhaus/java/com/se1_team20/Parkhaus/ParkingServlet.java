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
import java.util.Arrays;

public abstract class ParkingServlet extends HttpServlet implements ParkingServletable{

    /* default implementation */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    /* default implementation */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { handleRequest(request, response);
      handleBody(request,response);

    }

    public void handleBody(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");

        /* getting the String containing of: [EVENT, NR, BEGIN, END, PRICE] */
        String body                       = ParkingServletable.getBody(request);
        System.out.println(body);

        String[] params               =  body.split(",");
        String event                     =  params[0];
        String[] restParams         =  Arrays.copyOfRange(params, 1, params.length);

        /* block variables for ServletContexts of buttons, so we can do the math with them */
        StringBuilder priceString = new StringBuilder();
        double            price           = 0.;
        handleEvent(event);
    }
        public void handleEvent(String event)
        {
            /* when a car leaves the parkhaus */
            if ("leave".equals(event))
            {
                priceString.append(params[4]);

                /* parses String */
                price = (!(priceString.equals("_"))) ? Double.parseDouble(priceString.toString()) :  price;

                /*
                 * doing the math for the buttons
                 * formats the price to xx.yy; e.g. makes 1234 to 12.34,-
                 * stores variables in ServletContexts, so they will be returned when hitting the corresponding buttons
                 */
                getContext().setAttribute("total_revenue", (getTotalRevenue() + (price / 100)));
                getContext().setAttribute("average_revenue", (getTotalRevenue() / getTotalCars()));

                /* functional, but unnecessarily complex version of average revenue */
            /*
                 getContext().setAttribute("average_revenue", cars().stream()
                                            .mapToDouble(CarIF::price)
                                                               .average());
            */

                getContext().setAttribute("total_cars", getTotalCars());
                getContext().setAttribute("get_bill", price);
            }
            /* when a car enters the parkhaus */
            else if ("enter".equals(event))
            {
                CarIF newCar = new Car( restParams );
                cars().add( newCar );
                System.out.println( "enter," + newCar );
                /* re-direct car to another parking lot
                 *  out.println( locator( newCar ) );
                 */

            }

        }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /* default implementation */
    final public ServletContext getContext() { return getServletConfig().getServletContext();}

    /* default implementation */
    final public void destroy(){
        System.out.println("Server annihilated. Nothing shall remain of this servant");
    }


}
