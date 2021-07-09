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
/*Alle Methoden ,die nihct kommentiert sind ,sind vom ganzem Team*/

package com.se1_team20.Parkhaus.PARKHAUS;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet("/ParkhausServlet")
public abstract class ParkhausServlet extends ParkingServlet {


    static List<String>parkingspaces=new ArrayList<>(Arrays.asList(null,null,null,null,null,null,null,null,null,null));
    static int max=10;   //Standard size

    /* abstract methods, to be defined in subclasses */
    abstract String getNAME(); // each ParkhausServlet should have a name, e.g. "Level1"

    public ParkhausModel pModel =  new ParkhausModel();

    //Reduces or increases the parking spaces
    // erstellt von Preet
    protected final void configMax(int newmax){

        int count;

        if(newmax > max){

            count=newmax-max;

            while(count!=0){

                parkingspaces.add(null); //Adding more parking spaces

                count--;
            }
        }
        else{

            count=max-newmax;

            while(count!=0){

                parkingspaces.remove(parkingspaces.size()-1);

                count--;
            }
        }

        max=newmax;

    }
    //erstellt vom Team
    public final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
        else if ("cmd".equals(command) && "config&name".equals(param)) {handleConfig(param, response);}
        else if ("cmd".equals(command) && "cars&name".equals(param)) {savedCars(param, response);}
        else if ("cmd".equals(command) && "spaces".equals(param)){handleRequest(request,response);}
        else {System.out.println("invalid Command: " + request.getQueryString());}
    }



    protected final void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcherObject = null;
        if (request.getQueryString().split("=")[1].equals("checkout"))
        {
            //TODO: RequestDispatcherObject ist unnötig: Siehe CheckoutAuthenticationServlet
            requestDispatcherObject = request.getRequestDispatcher("CheckoutAuthenticationView.jsp");
            requestDispatcherObject.forward(request, response);
        }
        else if(request.getQueryString().split("=")[1].equals("spaces"))
        {
            request.setAttribute("parameter",parkingspaces);
            request.getRequestDispatcher("Parking_spacesView.jsp").forward(request,response);
         }
        else if (request.getQueryString().split("=")[1].equals("management"))
        {
            requestDispatcherObject = request.getRequestDispatcher("ManagementAuthenticationView.jsp");
            requestDispatcherObject.forward(request, response);
        }
    }

    protected final void handleEvent(final String EVENT, final String[] PARAMS)
    {
        if ("enter".equals(EVENT)) {handleEnter(PARAMS);}
        else if ("leave".equals(EVENT)) {handleLeave(PARAMS);}
        else if ("occupied".equals(EVENT)) {handleOccupied(PARAMS);}
        else if ("change_max".equals(EVENT)) {configMax(Integer.parseInt(PARAMS[2]));}

    }

    private void handleEnter(final String[] PARAMS)
    {
        parkingspaces.set(Integer.parseInt(PARAMS[7])-1,"enter"+","+PARAMS[1]+","+PARAMS[7]);
        CarIF newCar = new Car( PARAMS );
        cars().add( newCar );
    }

     private void handleLeave(final String[] PARAMS)
    {
        parkingspaces.set(Integer.parseInt(PARAMS[7])-1,"leave"+","+PARAMS[1]+","+PARAMS[7]);

        StringBuilder priceString = new StringBuilder();
        double            price           = 0.;
        priceString.append(PARAMS[4]);
        price = (!(priceString.toString().equals("_"))) ? Double.parseDouble(priceString.toString()) :  price;

        ServletContext application = getContext();
        Double totalRev = pModel.getDoubleAttribute((Double) application.getAttribute("total_revenue"));

        getContext().setAttribute("total_revenue", (totalRev + (price / 100.)));
        getContext().setAttribute("average_revenue", (totalRev / (double) formerCars().size()));
        getContext().setAttribute("get_bill", price);
        getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(),Integer.parseInt(PARAMS[1]))); //Erasing Car from cars()
        getContext().setAttribute("total_cars", cars().size());


        CarIF carSave = new Car(PARAMS);
        formerCars().add(carSave); //Saving Old Car in formerCars()
    }
        //erstellt von Lukas
    private void handleOccupied(final String[] PARAMS)
    {
        String[] preid = PARAMS[1].split("[(]");
        String id = preid[1].substring(0,preid[1].length()-1);
        getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(),Integer.parseInt(id)));
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


    protected final void eventDoubleAttribute(HttpServletResponse response, ServletContext application, String attribute) throws IOException {
        final PrintWriter OUT = response.getWriter();
        Double doubleAttribute = pModel.getDoubleAttribute((Double) application.getAttribute(attribute));
        OUT.println(doubleAttribute + ",-");
        System.out.println(attribute + " = €" + doubleAttribute);
    }

    private void eventTotalCars(HttpServletResponse response) throws IOException {
        final PrintWriter OUT = response.getWriter();
        OUT.println(cars().size());
        System.out.println("total_cars = " + cars().size());
    }


    private void handleConfig(String name, HttpServletResponse response) {
        System.out.println("Config not implemented.");
    }

    private void savedCars(String param, HttpServletResponse response) {
        System.out.println("Saved Cars not implemented.");
    }

}


