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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.se1_team20.Parkhaus.Car;
import com.se1_team20.Parkhaus.CarIF;
import com.se1_team20.Parkhaus.ParkingServlet;

import java.util.ArrayList;
import java.util.List;

public class ParkhausModel {

    /*
     *  Model for Parkhaus
     *  Allgemeine Datenbeschaffung die bei allen Benötigt werden:
     *  Wie viel Autos insgesamt
     *  Zeit von Kunde im Parkhaus
     *
     * Bearbeitung Lukas + Test
     *
     */

    protected int kundenParkkosten(Car car) {
        return car.price();
    }

    protected String kundenID(Car car) {
        return car.id();
    }

    public Double getDoubleAttribute(Double attribute) {
        return (attribute == null) ? 0. : attribute;
    }

    /* TODO: fix this
     * currently returns all initialized cars and not just the ones inside the parking garage
     */
    final protected Long getTotalCars() {
        return (long) cars().size();
    }

    List<CarIF> cars() {
        if (getContext().getAttribute("cars" + getNAME()) == null) {
            getContext().setAttribute("cars" + getNAME(), new ArrayList<Car>());
        }
        return (List<CarIF>) getContext().getAttribute("cars" + getNAME());
    }

    /*
     * TODO: replace this by your own function
     * @return the number of the free parking lot to which the next incoming car will be directed
     */

    int locator(CarIF car) {
        /*  numbers of parking lots start at 1, not zero */
        return 1 + ((cars().size() - 1) % this.getMAX());
    }

}
