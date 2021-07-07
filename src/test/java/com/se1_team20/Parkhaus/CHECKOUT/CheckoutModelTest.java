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

package com.se1_team20.Parkhaus.CHECKOUT;

import com.se1_team20.Parkhaus.PARKHAUS.Car;
import com.se1_team20.Parkhaus.PARKHAUS.CarIF;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class CheckoutModelTest {

    List<CarIF> cars;
    CarIF car1;
    CarIF car2;
    CarIF car3;
    CarIF car4;
    CarIF car5;

    @BeforeEach
    void setUp() {
        this.car1 = new Car("leave,13,1625674332094,19500,3900,5de55913446d18eded0c2ebec25c762f,#3f0dac,2,Day,Limousine,SU-I 30".split(","));       
        this.car2 = new Car("leave,10,1625674332304,21970,4394,5137014724d32c81a6d4b9c8f66ab270,#63160c,3,Day,SUV,SU-K 77".split(","));             
        this.car3 = new Car("leave,77,1625674332605,24050,4810,61eb87b183a251d99e4baf4691c69014,#da31f4,4,Day,Limousine,SU-Q 94".split(","));       
        this.car4 = new Car("leave,27,1625674351559,10590,2118,fcb6f3f4c8792327ae70777eb88bf8a4,#fcbe19,7,Female,Limousine,SU-F 7".split(","));     
        this.car5 = new Car("leave,83,1625674351397,16340,3268,2ccd96976fe59639a2b5c5eddf8eb19e,#bb092c,9,Handicapped,Limousine,SU-T 8".split(","));
        this.cars = new ArrayList<>();
        this.cars.add(this.car1);
        this.cars.add(this.car2);
        this.cars.add(this.car3);
        this.cars.add(this.car4);
        this.cars.add(this.car5);
    }

    @AfterEach
    void tearDown() {
        this.car1 = null;
        this.car2 = null;
        this.car3 = null;
        this.car4 = null;
        this.car5 = null;
        this.cars = null;
    }

    @Test
    @DisplayName("filter by license")
    void testFilterByLicensePlate() {
        assertEquals(this.car1, CheckoutModel.filterByLicensePlate(this.cars, "SU-I 30"));
        assertNotEquals(this.car2, CheckoutModel.filterByLicensePlate(this.cars, "SU-I 30"));
        assertNull(CheckoutModel.filterByLicensePlate(this.cars, "SU-I 3456tdf0"));
    }

}