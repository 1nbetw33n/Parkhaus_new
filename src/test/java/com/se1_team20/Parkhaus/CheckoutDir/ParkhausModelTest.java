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
import com.se1_team20.Parkhaus.CarIF;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausModelTest {

    private ParkhausModel cm;
    private Car carEnter = new Car(null);
    private Car carLeave = new Car(null);
    private List<CarIF> cars = null;

    @BeforeEach
    void setUp() {
        cm = new ParkhausModel();
        carEnter = new Car(new String[]{"enter","173","1624278150403","","","8319c7d02f8b786e4f1a231af06da0c7","#714934","7","_","_","173"});
        carLeave = new Car(new String[]{"leave","173","1624278155427","5018","502","8319c7d02f8b786e4f1a231af06da0c7","#714934","6","_","_","173"});
        cars.add(carEnter);
    }

    @AfterEach
    void tearDown() {
        cm = null;
        carEnter = null;
        carLeave = null;
        cars = null;
    }

    @Test
    @DisplayName("Der Preis für ein geparktes Auto wird korrekt angezeigt")
    void filterIDEraseTest() {
        List<CarIF> newcars = null;
        newcars.add(carEnter);
        assertEquals(cars, newcars);
        assertNotEquals(cars, cm.filterIDErase(newcars, carEnter.id()));
    }

    @Test
    @DisplayName("Die KundenID für ein geparktes Auto wird korrekt angezeigt")
    void kundenIDTest() {
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", carEnter.id());
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", carLeave.id());
        assertEquals(carLeave.id(),carEnter.id());
    }
}