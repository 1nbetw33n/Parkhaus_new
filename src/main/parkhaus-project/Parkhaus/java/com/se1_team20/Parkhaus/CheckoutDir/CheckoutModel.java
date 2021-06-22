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

package com.se1_team20.Parkhaus.CheckoutDir;

import com.se1_team20.Parkhaus.Car;

import javax.servlet.ServletContext;

public class CheckoutModel {

    /*
    *  Model for Checkout:
    *  Allgemeine Datenbeschaffung die bei allen Benötigt werden:
    *  Wie viel Autos insgesamt
    *  Zeit von Kunde im Parkhaus
    *
    * Bearbeitung Lukas + Test
    *
     */

    protected int kundenParkkosten(Car car){
        return car.price();
    }

    protected String kundenID(Car car) {
        return car.id();
    }

    final protected Double getTotalRevenue()
    {
        Double         totalRevenue;
        ServletContext application = getContext();
        totalRevenue                     = (Double) application.getAttribute("total_revenue");
        totalRevenue                     = (totalRevenue == null) ? 0.0 : totalRevenue;
        return totalRevenue;
    }

}
