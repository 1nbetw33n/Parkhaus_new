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
/* Bearbeitet von Lukas*/
package com.se1_team20.Parkhaus.PARKHAUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkhausModel {

    /*
     * Bearbeitung Lukas, Preet
     */


    //For JUnit Test purpose
    static int max=10;
    static List<String> parkingspaces = new ArrayList<>(Arrays.asList(null, null, null, null, null, null, null, null, null, null));

    /* Preet */
    protected final int configMax(int newmax) {

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

        return max;

    }

    /* Lukas */
    public Double getDoubleAttribute(Double attribute) {
        return (attribute == null) ? 0. : attribute;
    }
    /* Lukas */
    public long filterCustomerAmountWithoutSpecific(List<CarIF> cars , String withoutCustomerType) {
        return cars.stream().filter(x -> !x.kunde().equals(withoutCustomerType)).count();
    }
    /* Lukas */
    public List<CarIF> filterHashErase(List<CarIF> cars, String hash) {
        return  cars.stream().filter((x -> !x.hash().equals(hash))).collect(Collectors.toList());
    }
    /* Lukas */
    public List<CarIF> filterNrErase(List<CarIF> cars, int nr) {
        return  cars.stream().filter((x -> x.nr() != nr)).collect(Collectors.toList());
    }



}
