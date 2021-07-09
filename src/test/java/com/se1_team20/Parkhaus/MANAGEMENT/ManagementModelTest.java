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

package com.se1_team20.Parkhaus.MANAGEMENT;

import com.se1_team20.Parkhaus.PARKHAUS.Car;
import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementModelTest {

    ManagementModel mModel;
    protected CarIF car1;
    protected CarIF car2;
    protected CarIF car3;
    protected CarIF car4;
    protected CarIF car5;
    protected CarIF car6;
    protected CarIF car7;
    protected CarIF car8;
    protected CarIF car9;
    protected CarIF car10;
    protected CarIF car11;
    protected List<CarIF>     cars;

    @BeforeEach
    void setUp() {
        mModel = new ManagementModel();
        cars = new ArrayList<>(5);
        car1 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Day", "Limousine", "SU-T 87"});
        car2 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Company", "Limousine", "SU-T 87"});
        car3 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Company", "Limousine", "SU-T 87"});
        car4 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Handicapped", "Limousine", "SU-T 87"});
        car5 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Company", "Van", "SU-T 87"});
        car6 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Company", "SUV", "SU-T 87"});
        car7 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Company", "Motorcycle", "SU-T 87"});
        car8 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Day", "Limousine", "SU-T 87"});
        car9 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Day", "Limousine", "SU-T 87"});
        car10 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Female", "Limousine", "SU-T 87"});
        car11 = new Car(new String[]{"leave", "55", "1625583886541", "25840", "5168", "664482a016d1d5c563de606659b11d61", "#bd6764", "1", "Female", "Limousine", "SU-T 87"});
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);
        cars.add(car11);
    }

    @AfterEach
    void tearDown() {
        mModel = null;
        cars = null;
        car1 = null;
        car2 = null;
        car3 = null;
        car4 = null;
        car5 = null;
        car6 = null;
        car7 = null;
        car8 = null;
        car9 = null;
        car10 = null;
        car11 = null;
    }

    @Test
    void filterAmountOfType() {
        assertEquals(3L, mModel.filterAmountOfCustomerType(cars, "Day"));
        assertEquals(5L, mModel.filterAmountOfCustomerType(cars, "Company"));
        assertEquals(1L, mModel.filterAmountOfCustomerType(cars, "Handicapped"));
        assertEquals(2L, mModel.filterAmountOfCustomerType(cars, "Female"));
    }

    @Test
    void filterPercentagesOfType() {
        assertEquals(0L, mModel.filterPercentagesOfCustomerType(cars, "Day"));
        /* Is this supposed to fail? */ //assertEquals(100L, mModel.filterPercentagesOfCustomerType(cars, "Company"));
    }

    @Test
    void filterDurationCustomerCar() {
        assertEquals(25840L, mModel.filterDurationCustomerCar(cars, "Handicapped", "Limousine"));
        assertEquals(51680L, mModel.filterDurationCustomerCar(cars, "Company", "Limousine"));
        assertEquals(77520L, mModel.filterDurationCustomerCar(cars, "Day", "Limousine"));
        assertEquals(25840L, mModel.filterDurationCustomerCar(cars, "Company", "Motorcycle"));
        assertEquals(0L, mModel.filterDurationCustomerCar(cars, "Female", "SUV"));
    }

   @Test
    void filterDurationCustomer() {

    }
}