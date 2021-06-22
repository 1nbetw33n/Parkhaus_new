package com.se1_team20.Parkhaus;

import com.se1_team20.Parkhaus.CheckoutDir.ParkhausModel;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




/* TODO: inspect, if we need the @WebServlet annotation for ParkhausServlet */
/* we decided to use the different levels to display the interface, do we need this servlet as an web servlet? */

@WebServlet("/ParkhausServlet")
public abstract class ParkhausServlet extends ParkingServlet {

    /**
     * TODO: Funktional ParkhausServlet im arbeiten -> Wo? Welche berechnung braucht das?
     * TODO: evaluate cars()
     * cars() stores all initialized cars and not just the ones entered
     */

    /* abstract methods, to be defined in subclasses */
    abstract String getNAME(); // each ParkhausServlet should have a name, e.g. "Level1"
    abstract int getMAX(); // maximum number of parking slots of a single parking level
    abstract String getCONFIG(); // configuration of a single parking level

    private ParkhausModel pModel;

    final public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");

        String[] requestParamString = request.getQueryString().split("=");
        String command              = requestParamString[0];
        String param                = requestParamString[1];

        ServletContext application = getContext();

        /* calculate total revenue for all cars */
        if ("cmd".equals(command) && "total_revenue".equals(param))
        {
            final PrintWriter OUT = response.getWriter();

            Double totalRev = pModel.getDoubleAttribute((Double) application.getAttribute("total_revenue"));
            OUT.println(totalRev + ",-");
            System.out.println("total_revenue = €" + totalRev);
        }
        /* calculate average revenue per car */
        else if ("cmd".equals(command) && "average_revenue".equals(param))
        {

            final PrintWriter OUT    = response.getWriter();
            Double averageRev = pModel.getDoubleAttribute((Double) application.getAttribute("average_revenue"));
            OUT.println(averageRev + ",-");
            System.out.println("average_revenue = €" + averageRev);
        }
        /* count all cars that leaves the parkhaus */
        else if ("cmd".equals(command) && "total_cars".equals(param))
        {
            final PrintWriter OUT = response.getWriter();
            OUT.println(getTotalCars());
            System.out.println("total_cars = " + getTotalCars());
        }
        /* prints the bill when a car leaves */
        else if ("cmd".equals(command) && "get_bill".equals(param))
        {
            final PrintWriter OUT = response.getWriter();
            OUT.println(getBill() + ",-");
            System.out.println("your bill = €" + getBill());
        }
        /* enters checkout interface */
        else if ("cmd".equals(command) && "checkout".equals(param))
        {
        }
        /* displays the chart */
        else if("cmd".equals(command) && "my_chart".equals(param))
        {
            /* TODO: needs to be implementing somewhere in the future */
        }
        /* command doesnt match with the specified commands above */
        else
        {
            System.out.println("invalid Command: " + request.getQueryString());
        }
    }

    final public void handleBody(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        /* getting the String containing of: [EVENT, NR, BEGIN, END, PRICE] */
        String body                       = ParkingServletable.getBody(request);
        System.out.println(body);
        handleEvent(
                body.split(",")[0],
                body.split(","),
                Arrays.copyOfRange(body.split(","), 1, body.split(",").length)
        );
    }

    final public void handleEvent(final String EVENT, final String[] PARAMS, final String[] RESTPARAMS)
    {
        if ("enter".equals(EVENT))
    {
        handleEnter(RESTPARAMS);
    }
        else if ("leave".equals(EVENT))
        {
            handleLeave(PARAMS);
        }
    }

    final protected void handleEnter(final String[] RESTPARAMS)
    {
        CarIF newCar = new Car( RESTPARAMS );
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
        getContext().setAttribute("average_revenue", (totalRev / getTotalCars()));
        getContext().setAttribute("total_cars", getTotalCars());
        getContext().setAttribute("get_bill", price);

        getContext().setAttribute("cars" + getNAME(), cars().stream().filter(x-> !x.id().equals(PARAMS[0])));
    }



    /*final protected Double getTotalRevenue()
    {
        Double totalRevenue;
        ServletContext application = getContext();
        totalRevenue                     = (Double) application.getAttribute("total_revenue");
        totalRevenue                     = (totalRevenue == null) ? 0.0 : totalRevenue;
        return totalRevenue;
    }

    */


    /*final protected Double getAverageRevenue()
    {
        Double averageRevenue;
        ServletContext application = getContext();
        averageRevenue                = (Double) application.getAttribute("average_revenue");
        averageRevenue                = (averageRevenue == null) ? 0. : averageRevenue;
        return averageRevenue;
    }
  */

    /* TODO: fix this
     * currently returns all initialized cars and not just the ones inside the parking garage
     */
    final protected Long getTotalCars() {return (long) cars().size();}


    final protected Double getBill()
    {
        Double bill;
        ServletContext application = getContext();
        bill                                      = (Double) application.getAttribute("get_bill");
        bill                                      = (bill == null) ? 0. : bill;
        return bill;
    }


    /*
     * @return the list of all cars stored in the servlet context so far
     */
    @SuppressWarnings("unchecked")
    List<CarIF> cars()
    {
        if ( getContext().getAttribute( "cars"+ getNAME() ) == null )
        {
            getContext().setAttribute( "cars"+ getNAME(), new ArrayList<Car>() );
        }
        return (List<CarIF>) getContext().getAttribute( "cars"+ getNAME() );
    }


    /*
     * TODO: replace this by your own function
     * @return the number of the free parking lot to which the next incoming car will be directed
     */
    int locator( CarIF car )
    {
        /*  numbers of parking lots start at 1, not zero */
        return 1 + (( cars().size() - 1 ) % this.getMAX());
    }


}


