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
import java.util.stream.Collectors;

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

    List<CarIF> cars;

    public Double getDoubleAttribute(Double attribute) {
        return (attribute == null) ? 0. : attribute;
    }

    public void setCarsModel (List<CarIF> cars) {
        this.cars = cars;
    }

    public List<CarIF> filterIDErase(List<CarIF> cars, String id) {
        return  cars.stream().filter((x -> !x.id().equals(id))).collect(Collectors.toList());
    }

}
