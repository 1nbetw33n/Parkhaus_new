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

import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import com.se1_team20.Parkhaus.PARKINGSPACE.SpaceIF;

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
     * TODO: Interfaces für die jeweiligen Kategorien: CARS, Parkplätze, Berechnungen
     */

    List<CarIF> cars;
    List<SpaceIF> spaces;

    public Double getDoubleAttribute(Double attribute) {
        return (attribute == null) ? 0. : attribute;
    }

    public void setCarsModel (List<CarIF> cars) {
        this.cars = cars;
    }

    public List<CarIF> filterColorErase(List<CarIF> cars, String color) {
        return  cars.stream().filter((x -> !x.color().equals(color))).collect(Collectors.toList());
    }

    public List<CarIF> filterNrErase(List<CarIF> cars, int nr) {
        return  cars.stream().filter((x -> x.nr() != nr)).collect(Collectors.toList());
    }

    public void setSpacesModel(List<SpaceIF> spaces) { this.spaces = spaces;}

    /* @return the number of the free parking lot to which the next incoming car will be directed */
    public int locator(int max)
    {
        /*  numbers of parking lots start at 1, not zero */
        return 1 + (( cars.size() - 1 ) % max);
    }

}
