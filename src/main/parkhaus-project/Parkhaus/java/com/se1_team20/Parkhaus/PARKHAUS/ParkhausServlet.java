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

package com.se1_team20.Parkhaus.PARKHAUS;


import com.se1_team20.Parkhaus.PARKINGSPACE.ParkingSpace;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;


@WebServlet("/ParkhausServlet")
public abstract class ParkhausServlet extends ParkingServlet {

    /**
     * handleEnter() does not check if there is available space
     */

    List<Boolean>parkingspaces=new ArrayList<>(10);  //To Do: getMAX as size of the ArrayList

    /* abstract methods, to be defined in subclasses */
    abstract String getNAME(); // each ParkhausServlet should have a name, e.g. "Level1"
    abstract int getMAX(); // maximum number of parking slots of a single parking level
    abstract String getCONFIG(); // configuration of a single parking level

    public ParkhausModel pModel =  new ParkhausModel();

    final public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        String[] requestParamString = request.getQueryString().split("=");
        String command              = requestParamString[0];
        String param                = requestParamString[1];

        ServletContext application = getContext();

        if ("cmd".equals(command) && "total_revenue".equals(param)) { eventDoubleAttribute(response, application, "total_revenue"); }

        else if ("cmd".equals(command) && "average_revenue".equals(param)) {eventDoubleAttribute(response, application, "average_revenue");}
        else if ("cmd".equals(command) && "total_cars".equals(param)) { eventTotalCars(response);}
        else if ("cmd".equals(command) && "get_bill".equals(param)) {eventDoubleAttribute(response, application, "get_bill");}
        else if ("cmd".equals(command) && "checkout".equals(param))  {handleRequest(request, response);}
        else if ("cmd".equals(command) && "management".equals(param)) {handleRequest(request, response);}
        else if ("cmd".equals(command) && "my_chart".equals(param)) {eventMyChart(response);}
        else if ("cmd".equals(command) && "config&name".equals(param)) {handleConfig(param, response);}
        else if ("cmd".equals(command) && "cars&name".equals(param)) {savedCars(param, response);}
        else {System.out.println("invalid Command: " + request.getQueryString());}
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcherObject = null;
        if (request.getQueryString().split("=")[1].equals("checkout"))
        {
            requestDispatcherObject = request.getRequestDispatcher("CheckoutAuthenticationView.jsp");
            requestDispatcherObject.forward(request, response);
        }
        else if(request.getQueryString().split("=")[1].equals("parkingspaces"))
        {
            requestDispatcherObject = request.getRequestDispatcher("ParkingspacesView.jsp");
            requestDispatcherObject.forward(request, response);
         }
        else if (request.getQueryString().split("=")[1].equals("management"))
        {
            requestDispatcherObject = request.getRequestDispatcher("ManagementAuthenticationView.jsp");
            requestDispatcherObject.forward(request, response);
        }
    }

    final public void handleBody(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        //getting the String containing of: [EVENT, NR, BEGIN, END, PRICE]
        String body                       = ParkingServletable.getBody(request);
        System.out.println(body);
        handleEvent(
                body.split(",")[0],
                body.split(",")
        );
    }

    final public void handleEvent(final String EVENT, final String[] PARAMS)
    {
        if ("enter".equals(EVENT)) {handleEnter(PARAMS);}
        else if ("leave".equals(EVENT)) {handleLeave(PARAMS);}
        else if ("occupied".equals(EVENT)) {
            String[] preid = PARAMS[1].split("[(]");
            String id = preid[1].substring(0,preid[1].length()-1);
            getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(),Integer.parseInt(id)));
        }
    }

    final protected void handleEnter(final String[] PARAMS)
    {
        //TODO: Parkplätze implementieren
        CarIF newCar = new Car( PARAMS );
        cars().add( newCar );


    }

    final protected void handleLeave(final String[] PARAMS)
    {

        StringBuilder priceString = new StringBuilder();
        double            price           = 0.;
        priceString.append(PARAMS[4]);
        price = (!(priceString.toString().equals("_"))) ? Double.parseDouble(priceString.toString()) :  price;

        ServletContext application = getContext();
        Double totalRev = pModel.getDoubleAttribute((Double) application.getAttribute("total_revenue"));

        getContext().setAttribute("total_revenue", (totalRev + (price / 100)));
        getContext().setAttribute("average_revenue", (totalRev / cars().size()));
        getContext().setAttribute("total_cars", cars().size());
        getContext().setAttribute("get_bill", price);
        getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(),Integer.parseInt(PARAMS[1]))); //Erasing Car from cars()

        CarIF carSave = new Car(PARAMS);
        formerCars().add(carSave); //Saving Old Car in formerCars()

    }

    /*
     * @return the list of all cars stored in the servlet context so far
     * Lukas: ParkhausModell implementierung hinzugefügt um Logik statisch zu transferieren
     *  -> Funktionsaufruf sollte eigentlich entfallen, mir ist gerade keine bessere Lösung gekommen
     */

    @SuppressWarnings("unchecked")
    List<CarIF> cars() //List of all cars which are inside the Parkhaus
    {
        if ( getContext().getAttribute( "cars"+ getNAME() ) == null )
        {
            getContext().setAttribute( "cars"+ getNAME(), new ArrayList<Car>() );
        }
        List<CarIF> cars = (List<CarIF>) getContext().getAttribute( "cars"+ getNAME() );
        pModel.setCarsModel(cars);
        return cars;
    }

    List<CarIF> formerCars() { // List of all cars which have left the Parkhaus
        if ( getContext().getAttribute( "former-cars"+ getNAME() ) == null )
        {
            getContext().setAttribute( "former-cars"+ getNAME(), new ArrayList<Car>() );
        }
        List<CarIF> formerCars = (List<CarIF>) getContext().getAttribute( "former-cars"+ getNAME() );
        return formerCars;
    }

    List<ParkingSpace> spaces() {
        if(getContext().getAttribute("spaces" + getNAME()) == null) {
            getContext().setAttribute("spaces" + getNAME(), new ArrayList<ParkingSpace>(getMAX()));
            // Currently Fixed Length -> What happens when we change the MAX value to this?
        }
        List<ParkingSpace> spaces = (List<ParkingSpace>) getContext().getAttribute("spaces" + getNAME());
        pModel.setSpacesModel(spaces);
        return spaces;
    }


    final protected void eventDoubleAttribute(HttpServletResponse response, ServletContext application, String attribute) throws IOException {
        final PrintWriter OUT = response.getWriter();
        Double doubleAttribute = pModel.getDoubleAttribute((Double) application.getAttribute(attribute));
        OUT.println(doubleAttribute + ",-");
        System.out.println(attribute + " = €" + doubleAttribute);
    }

    final protected void eventTotalCars(HttpServletResponse response) throws IOException {
        final PrintWriter OUT = response.getWriter();
        OUT.println(cars().size());
        System.out.println("total_cars = " + cars().size());
    }

/*
    final protected void eventCheckOut(HttpServletResponse response)
    {
         TODO: COMING SOON

        //ArrayList<String>std=new ArrayList<>();

       request.setAttribute("data", std);

          RequestDispatcher rd =  request.getRequestDispatcher("CheckoutView.jsp");

          rd.forward(request,response);

}
        */

    final protected void eventMyChart(HttpServletResponse response)
    {
        /* TODO: COMING SOON */
    }

    public void handleConfig(String name, HttpServletResponse response) {
        System.out.println(name);
    }

    private void savedCars(String param, HttpServletResponse response) {
        System.out.println(param);
    }


}


