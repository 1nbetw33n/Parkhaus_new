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

import com.se1_team20.Parkhaus.PARKHAUS.Car;
import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import com.se1_team20.Parkhaus.PARKHAUS.ParkhausModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausModelTest {

    private ParkhausModel cm;
    private Car carEnter;
    private Car carLeave;
    private Car car1Enter;
    private Car car1Leave;
    private List<CarIF> cars;
    private ParkhausModel obj;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cm = new ParkhausModel();
        carEnter = new Car(new String[]{"enter","173","1624278150403","","","8319c7d02f8b786e4f1a231af06da0c7","#714934","7","Female","_","173"});
        carLeave = new Car(new String[]{"leave","173","1624278155427","5018","502","8319c7d02f8b786e4f1a231af06da0c7","#714934","6","Female","_","173"});
        car1Enter = new Car(new String[]{"enter", "173", "1624278150403", "_", "_", "8319c7d02f8b786e4f1a231af06da0c7", "#714934","7","Handicapped", "Motorcycle", "SU-A 84"});
        car1Leave = new Car(new String[]{"leave","173","1624278155427","5018","502","8319c7d02f8b786e4f1a231af06da0c7","#714934","7","Handicapped", "Motorcycle", "SU-A 84"});

        cars.add(carEnter);
        cars.add(carLeave);
        cars.add(car1Enter);
        cars.add(car1Leave);
        obj=new ParkhausModel();
    }

    @AfterEach
    void tearDown() {
        cm = null;
        carEnter = null;
        carLeave = null;
        car1Enter = null;
        car1Leave = null;
        cars = null;
        obj=null;
    }

    @Test

    void configMaxTest(){

     assertEquals( 10,obj.configMax(10));


    }



    @Test
    void filterCustomerAmountWithoutSpecificTest(){

        assertEquals(2,cm.filterCustomerAmountWithoutSpecific(cars,"Female"));
        assertEquals(2,cm.filterCustomerAmountWithoutSpecific(cars,"Handicapped"));


    }

    @Test
    @DisplayName("Das Auto einer bestimmten Farbe wird korrekt gelöscht")
    void filterColorEraseTest() {
        List<CarIF> newcars = new ArrayList<>();
        newcars.add(carEnter);
        assertEquals(cars, newcars);
        assertNotEquals(cars, cm.filterColorErase(newcars, carEnter.hash()));

        List<CarIF> newcars1 = new ArrayList<>();

        newcars1.add(car1Enter);
        assertEquals(cars,newcars1);
        assertNotEquals(cars,cm.filterColorErase(newcars1, car1Enter.hash()));


    }

    @Test
    @DisplayName("Die KundenID für ein geparktes Auto wird korrekt angezeigt")
    void kundenIDTest() {
        assertEquals(173, carEnter.nr());
        assertEquals(173, carLeave.nr());
        assertEquals(carLeave.nr(), carEnter.nr());

    }
}