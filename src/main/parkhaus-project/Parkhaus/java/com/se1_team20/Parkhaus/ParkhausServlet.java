package com.se1_team20.Parkhaus;

import com.se1_team20.Parkhaus.PARKHAUS.ParkingServletable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/ParkhausServlet")
public abstract class ParkhausServlet extends ParkingServlet {

    /**
     * handleEnter() does not check if there is available space
     */

    /* abstract methods, to be defined in subclasses */
    abstract String getNAME(); // each ParkhausServlet should have a name, e.g. "Level1"
    abstract int getMAX(); // maximum number of parking slots of a single parking level
    abstract String getCONFIG(); // configuration of a single parking level

    public ParkhausModel pModel =  new ParkhausModel();

    final public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
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
        else if ("cmd".equals(command) && "checkout".equals(param)) /*{eventCheckOut(response);*/
            {
                try{
                    handleRequest(request, response);
                } catch (final Exception E) {
                    E.printStackTrace();
                }
            }
        else if("cmd".equals(command) && "my_chart".equals(param)) {eventMyChart(response);}
        else {System.out.println("invalid Command: " + request.getQueryString());}
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcherObject = request.getRequestDispatcher("/CheckoutViewJSP.jsp");
        requestDispatcherObject.include(request, response);
    }

    final public void handleBody(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        /* getting the String containing of: [EVENT, NR, BEGIN, END, PRICE] */
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

        getContext().setAttribute("cars" + getNAME(), pModel.filterIDErase(cars(),PARAMS[5]));
    }

    /*
     * @return the list of all cars stored in the servlet context so far
     * Lukas: ParkhausModell implementierung hinzugefügt um Logik statisch zu transferieren
     *  -> Funktionsaufruf sollte eigentlich entfallen, mir ist gerade keine bessere Lösung gekommen
     */

    @SuppressWarnings("unchecked")
    List<CarIF> cars()
    {
        if ( getContext().getAttribute( "cars"+ getNAME() ) == null )
        {
            getContext().setAttribute( "cars"+ getNAME(), new ArrayList<Car>() );
        }
        List<CarIF> cars = (List<CarIF>) getContext().getAttribute( "cars"+ getNAME() );
        pModel.setCarsModel(cars);
        return cars;
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


    final protected void eventCheckOut(HttpServletResponse response)
    {
        /* TODO: COMING SOON*/

        //ArrayList<String>std=new ArrayList<>();

       /* request.setAttribute("data", std);

          RequestDispatcher rd =  request.getRequestDispatcher("CheckoutViewJSP.jsp");

          rd.forward(request,response);


        */


    }

    final protected void eventMyChart(HttpServletResponse response)
    {
        /* TODO: COMING SOON */
    }

}


