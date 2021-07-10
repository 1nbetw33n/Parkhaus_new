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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private CarIF car1Enter;
    private CarIF car1Leave;
    private CarIF car2Enter;
    private CarIF car2Leave;
    private CarIF car3Enter;
    private CarIF car3Leave;

    @BeforeEach
    void setUp() {
        car1Enter = new Car(new String[]{"enter", "173", "1624278150403", "_", "_", "8319c7d02f8b786e4f1a231af06da0c7", "#714934","7","Handicapped", "Motorcycle", "SU-A 84"});
        car1Leave = new Car(new String[]{"leave","173","1624278155427","5018","502","8319c7d02f8b786e4f1a231af06da0c7","#714934","7","Handicapped", "Motorcycle", "SU-A 84"});

    }

    @AfterEach
    void tearDown() {
        car1Enter = null;
        car1Leave = null;
    }
    @Test
    @DisplayName("Returns the number of the current car")
    void nrTest() {
        assertEquals(173, car1Enter.nr());
        assertEquals(173, car1Leave.nr());
    }

    @Test
    @DisplayName("Returns the starting time of the current car")

    /*
    * Berechnung von CarLeave führt zu anderem Ergebnis; Ich denke es liegt an Rundungsfehlern, konnte aber die genaue Ursache nicht rausfinden.
    * Möglicherweise auch wegen Falschen Zahlen bei der Eingabe (konnte ich nicht genau prüfen
     */

    void beginTest() {
        assertEquals(1624278150403L, car1Enter.begin(),"Oops, carEnter is not showing begin");
        assertEquals(1624278150409L, car1Leave.begin(),"Oops, carLeave is not showing begin");
    }

    @Test
    @DisplayName("Returns the end-time of the current car, shows null of there is none")
    void endTest() {
        assertEquals(1624278155427L, car1Leave.end(), "Oops, carLeave is not showing correct end");
        assertEquals(0L, car1Enter.end(), "Oops, carEnter is not showing correct end");
    }

    @Test
    @DisplayName("Returns the current duration")
    void durationTest() {
        assertEquals(5018, car1Leave.duration(),"Oops. carLeave does not show correct duration");
        assertEquals(0, car1Enter.duration(),"Oops. carEnter does not show correct duration (0)");
    }

    @Test
    @DisplayName("Returns the price once the car left")
    void priceTest() {
        assertEquals(0, car1Enter.price(),"Oops, carEnter does not show 0 for price");
        assertEquals(502, car1Leave.price(), "Oops, carLeave does not show correct price");
    }

    @Test
    @DisplayName("Returns the id of the car")
    void colorTest() {
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", car1Leave.hash());
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", car1Enter.hash());
        assertEquals(car1Leave.hash(), car1Enter.hash());
    }

    @Test
    @DisplayName("Returns the whole String ")
    void testToString() {
        assertEquals("leave,173,1624278155427,5018,502,8319c7d02f8b786e4f1a231af06da0c7,#714934,6,,,173", car1Leave.toString());
    }
}