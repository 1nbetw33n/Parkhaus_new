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


    static List<String> parkingspaces = new ArrayList<>(Arrays.asList(null, null, null, null, null, null, null, null, null, null));
    static int max = 10;   //Standard size

    /* abstract methods, to be defined in subclasses */
    abstract String getNAME(); // each ParkhausServlet should have a name, e.g. "Level1"

    public ParkhausModel pModel = new ParkhausModel();

    //Reduces or increases the parking spaces
    // erstellt von Preet
    protected final void configMax(int newmax) {

        int count;

        if (newmax > max) {

            count = newmax - max;

            while (count != 0) {

                parkingspaces.add(null); //Adding more parking spaces

                count--;
            }
        } else {

            count = max - newmax;

            while (count != 0) {

                parkingspaces.remove(parkingspaces.size() - 1);

                count--;
            }
        }

        max = newmax;

    }

    //erstellt vom Team
    public final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String[] requestParamString = request.getQueryString().split("=");
        String command = requestParamString[0];
        String param = requestParamString[1];

        ServletContext application = getContext();

        if ("cmd".equals(command) && "checkout".equals(param)) {
            handleRequest(request, response);
        } else if ("cmd".equals(command) && "management".equals(param)) {
            handleRequest(request, response);
        } else if ("cmd".equals(command) && "config&name".equals(param)) {
            handleConfig(param, response);
        } else if ("cmd".equals(command) && "cars&name".equals(param)) {
            savedCars(param, response);
        } else if ("cmd".equals(command) && "spaces".equals(param)) {
            handleRequest(request, response);
        } else {
            System.out.println("invalid Command: " + request.getQueryString());
        }
    }


    protected final void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getQueryString().split("=")[1].equals("checkout")) {
            request.getRequestDispatcher("CheckoutAuthenticationView.jsp").forward(request, response);
        } else if (request.getQueryString().split("=")[1].equals("spaces")) {
            request.setAttribute("parameter", parkingspaces);
            request.getRequestDispatcher("Parking_spacesView.jsp").forward(request, response);
        } else if (request.getQueryString().split("=")[1].equals("management")) {
            request.getRequestDispatcher("ManagementAuthenticationView.jsp").forward(request, response);
        }
    }

    protected final void handleEvent(final String EVENT, final String[] PARAMS) {
        if ("enter".equals(EVENT)) {
            handleEnter(PARAMS);
        } else if ("leave".equals(EVENT)) {
            handleLeave(PARAMS);
        } else if ("occupied".equals(EVENT)) {
            handleOccupied(PARAMS);
        } else if ("change_max".equals(EVENT)) {
            configMax(Integer.parseInt(PARAMS[2]));
        }
    }

    private void handleEnter(final String[] PARAMS) {
        parkingspaces.set(Integer.parseInt(PARAMS[7]) - 1, "enter" + "," + PARAMS[1] + "," + PARAMS[7]);
        CarIF newCar = new Car(PARAMS);
        cars().add(newCar);
    }

    private void handleLeave(final String[] PARAMS) {
        parkingspaces.set(Integer.parseInt(PARAMS[7]) - 1, "leave" + "," + PARAMS[1] + "," + PARAMS[7]);

        CarIF carSave = new Car(PARAMS);
        formerCars().add(carSave); //Saving Old Car in formerCars()

        StringBuilder priceString = new StringBuilder();

        if (PARAMS[8].equals("Company")) {
            priceString.append("0"); //Company Customers dont count towards revenue
        } else {
            priceString.append(PARAMS[4]);
        }

        double price = (!(priceString.toString().equals("_"))) ? Double.parseDouble(priceString.toString()) : 0.;

        ServletContext application = getContext();
        long carsWithoutCompany =  pModel.filterCustomerAmountWithoutSpecific(formerCars(),"Company");

        Double totalRev = pModel.getDoubleAttribute((Double) application.getAttribute("total_revenue"));
        getContext().setAttribute("total_revenue", (totalRev + (price / 100.)));
        totalRev = pModel.getDoubleAttribute((Double) application.getAttribute("total_revenue"));

        getContext().setAttribute("average_revenue", (totalRev / carsWithoutCompany));

        getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(), Integer.parseInt(PARAMS[1]))); //Erasing Car from cars()

    }

    //erstellt von Lukas
    private void handleOccupied(final String[] PARAMS) {
        String[] preid = PARAMS[1].split("[(]");
        String id = preid[1].substring(0, preid[1].length() - 1);
        getContext().setAttribute("cars" + getNAME(), pModel.filterNrErase(cars(), Integer.parseInt(id)));
    }

    /*
     * @return the list of all cars stored in the servlet context so far
     */

    @SuppressWarnings("unchecked")
    List<CarIF> cars() //List of all cars which are inside the Parkhaus
    {
        if (getContext().getAttribute("cars" + getNAME()) == null) {
            getContext().setAttribute("cars" + getNAME(), new ArrayList<Car>());
        }
        List<CarIF> cars = (List<CarIF>) getContext().getAttribute("cars" + getNAME());

        return cars;
    }

    List<CarIF> formerCars() { // List of all cars which have left the Parkhaus
        if (getContext().getAttribute("former-cars" + getNAME()) == null) {
            getContext().setAttribute("former-cars" + getNAME(), new ArrayList<Car>());
        }
        List<CarIF> formerCars = (List<CarIF>) getContext().getAttribute("former-cars" + getNAME());
        return formerCars;
    }

    private void handleConfig(String name, HttpServletResponse response) {
        System.out.println("Config not implemented.");
    }

    private void savedCars(String param, HttpServletResponse response) throws IOException {

        StringBuilder builder = new StringBuilder();
        int index = 0;

        for (CarIF car : formerCars()) {
            ++index;
            if (formerCars().size() - 1 == index) {
                builder.append(car.toString());
            }
            builder.append(car.toString() + ",");
        }
        index = 0;
        for (CarIF car : cars()) {
            ++index;
            if (cars().size() - 1 == index) {
                builder.append(car.toString());
            }
            builder.append(car.toString() + ",");
        }

        PrintWriter out = response.getWriter();
        out.println(builder);

        System.out.println("Saved Cars:" + builder);
    }

}


