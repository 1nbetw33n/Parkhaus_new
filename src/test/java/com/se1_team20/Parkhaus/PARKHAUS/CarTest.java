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

        car2Enter = new Car(new String[]{"enter","80","1626096329072","_","_","61fc0e486f096c277de87b57868e2f51","#4b1923","9","Handicapped","Van","SU-K 76"});
        car2Leave = new Car(new String[]{"leave","80","1626096329072","2353630","235363","61fc0e486f096c277de87b57868e2f51","#4b1923","9","Handicapped","Van","SU-K 76"});

        car3Enter = new Car(new String[]{"enter","-1","1626096329072","_","_","61fc0e486f096c277de87b57868e2f51","null","-10","*","-","SU-K 76"});
        car3Leave = new Car(new String[]{"leave","-1","1626096329072","2353630","-23","61fc0e486f096c277de87b57868e2f51","null","-10","*","-","SU-K 76"});
    }

    @AfterEach
    void tearDown() {
        car1Enter = null;
        car1Leave = null;

        car2Enter = null;
        car2Leave = null;

        car3Enter = null;
        car3Leave = null;


    }
    @Test
    @DisplayName("Returns the number of the current car")
    void nrTest() {
        assertEquals(173, car1Enter.nr());
        assertEquals(173, car1Leave.nr());

        assertEquals(80,car2Enter.nr());
        assertEquals(80,car2Leave.nr());

        assertEquals(-1,car3Enter.nr());
        assertEquals(-1,car3Leave.nr());


    }

    @Test
    @DisplayName("Returns the starting time of the current car")


    void beginTest() {
        assertEquals(1624278150403L, car1Enter.begin(),"Oops, carEnter is not showing begin");
        assertEquals(1624278150409L, car1Leave.begin(),"Oops, carLeave is not showing begin");

        assertEquals(1626096329072L,car2Enter.begin(),"Oops,carEnter is not showing begin");
        assertEquals(1626096329072L,car2Leave.begin(),"Oops,carLeave is not showing begin");
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

        assertEquals(0, car2Enter.price(),"Oops, carEnter does not show 0 for price");
        assertEquals(235363, car2Leave.price(), "Oops, carLeave does not show correct price");

        assertEquals(0, car3Enter.price(),"Oops, carEnter does not show 0 for price");
        assertEquals(-23, car3Leave.price(), "Oops, carLeave does not show correct price");
    }
    @Test
    @DisplayName("Returns the space of the car")
    void spaceTest() {

        assertEquals(7,car1Enter.space(),"Oops, carEnter does not show the correct space");
        assertEquals(7,car1Leave.space(),"Oops, carEnter does not show the correct space");
        assertEquals(car1Enter.space(),car1Leave.space(),"Oops, the space are not equal");

        assertEquals(9,car2Enter.space(),"Oops, carEnter does not show the correct space");
        assertEquals(9,car2Leave.space(),"Oops, carEnter does not show the correct space");
        assertEquals(car2Enter.space(),car2Leave.space(),"Oops, the space are not equal");

        assertEquals(-10,car3Enter.space(),"Oops, carEnter does not show the correct space");
        assertEquals(-10,car3Leave.space(),"Oops, carEnter does not show the correct space");
        assertEquals(car3Enter.space(),car3Leave.space(),"Oops, the space are not equal");
    }

    @Test
    @DisplayName("Returns of the client of the car")
    void clientTest(){

        assertEquals("Handicapped",car1Enter.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals("Handicapped",car1Leave.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals(car1Enter.kunde(),car1Leave.kunde(),"Oops, the client are not equal");

        assertEquals("Handicapped",car2Enter.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals("Handicapped",car2Leave.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals(car2Enter.kunde(),car2Leave.kunde(),"Oops, the client are not equal");

        assertEquals("*",car3Enter.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals("*",car3Leave.kunde(),"Oops, carEnter does not show the correct client");
        assertEquals(car3Enter.kunde(),car3Leave.kunde(),"Oops, the client are not equal");


    }

    @Test
    @DisplayName("Returns the type of the car")
    void typecarTest(){

        assertEquals("Motorcycle",car1Enter.typeCar(),"Oops, carEnter does not show the correct type of the car");
        assertEquals("Motorcycle",car1Leave.typeCar(),"Oops, carEnter does not show the correct type of the car");
        assertEquals(car1Enter.typeCar(),car1Leave.typeCar(),"Oops, the type of the car are not equal");

        assertEquals("Van",car2Enter.typeCar(),"Oops, carEnter does not show the correct type of the car");
        assertEquals("Van",car2Leave.typeCar(),"Oops, carEnter does not show the correct type of the car");
        assertEquals(car2Enter.typeCar(),car2Leave.typeCar(),"Oops, the type of the car are not equal");
    }

    @Test
    @DisplayName("Returns the licenseplate of the car")
    void licenseplateTest(){

        assertEquals("SU-A 84",car1Enter.licensePlate(),"Oops, carEnter does not show the correct license plate of the car");
        assertEquals("SU-A 84",car1Leave.licensePlate(),"Oops, carEnter does not show the correct license plate of the car");
        assertEquals(car1Enter.licensePlate(),car1Leave.licensePlate(),"Oops, the license plate are not equal");

        assertEquals("SU-K 76",car2Enter.licensePlate(),"Oops, carEnter does not show the correct license plate of the car");
        assertEquals("SU-K 76",car2Leave.licensePlate(),"Oops, carEnter does not show the correct license plate of the car");
        assertEquals(car2Enter.licensePlate(),car2Leave.licensePlate(),"Oops, the license plate are not equal");

    }

    @Test
    @DisplayName("Returns the hash of the car")
    void hashTest() {
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", car1Leave.hash());
        assertEquals("8319c7d02f8b786e4f1a231af06da0c7", car1Enter.hash());
        assertEquals(car1Leave.hash(), car1Enter.hash());

        assertEquals("61fc0e486f096c277de87b57868e2f51", car2Leave.hash());
        assertEquals("61fc0e486f096c277de87b57868e2f51", car2Enter.hash());
        assertEquals(car2Leave.hash(), car2Enter.hash());
    }

    @Test
    @DisplayName("Returns the String of the Car, parted with '/'")
    void testToString() {
        assertEquals("173/1624278155427/5018/502/8319c7d02f8b786e4f1a231af06da0c7/#714934/7/Handicapped/Motorcycle/SU-A 84", car1Leave.toString());
        assertEquals("173/1624278150403/_/_/8319c7d02f8b786e4f1a231af06da0c7/#714934/7/Handicapped/Motorcycle/SU-A 84", car1Enter.toString());

        assertEquals("80/1626096329072/2353630/235363/61fc0e486f096c277de87b57868e2f51/#4b1923/9/Handicapped/Van/SU-K 76", car2Leave.toString());
        assertEquals("80/1626096329072/_/_/61fc0e486f096c277de87b57868e2f51/#4b1923/9/Handicapped/Van/SU-K 76", car2Enter.toString());
    }
}