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
/* Bearbeitet von Lukas */

package com.se1_team20.Parkhaus.MANAGEMENT;

import com.se1_team20.Parkhaus.PARKHAUS.CarIF;

import java.util.List;

public class ManagementModel {

    public long filterAmountOfCustomerType(List<CarIF> cars, String type){
        return (cars.stream().filter(x -> x.kunde().equals(type)).count());
    }
    public long filterPercentagesOfCustomerType(List<CarIF> cars, String type){
        return (((cars.stream().filter(x -> x.kunde().equals(type)).count())/cars.size())*100);
    }

    public long filterDurationCustomerCar(List<CarIF> cars, String customer, String typeCar) {
        return cars.stream().filter(x->x.kunde().equals(customer)).filter(x->x.typeCar().equals(typeCar)).map(x -> x.duration()).reduce(0,Integer::sum);
    }

    /* created by 1nbetw33n */
    public static Double filterRevenueByCustomer(final List<CarIF>CARS, final String CUSTOMERTYPE)
    {
        return CARS.stream()
                .filter(x -> x.kunde().equals(CUSTOMERTYPE))
                        .mapToDouble(CarIF::price)
                            .reduce(0, Double::sum);
    }

    public Double getDoubleAttribute(Double attribute) {
        return (attribute == null) ? 0. : attribute;
    }

}
