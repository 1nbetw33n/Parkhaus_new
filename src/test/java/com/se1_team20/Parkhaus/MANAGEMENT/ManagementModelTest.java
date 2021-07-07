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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagementModelTest {

    ManagementModel mModel;
    List<CarIF> cars;

    @BeforeEach
    void setUp() {
        mModel = new ManagementModel();
        cars = new ArrayList<CarIF>(5);
        CarIF car1 = new Car(new String[]{"leave","55","1625583886541","25840","5168","664482a016d1d5c563de606659b11d61","#bd6764","1","Company","Limousine","SU-T 87"});
        CarIF car2 = new Car(new String[]{"leave","55","1625583886541","25840","5168","664482a016d1d5c563de606659b11d61","#bd6764","1","Company","Limousine","SU-T 87"});
        CarIF car3 = new Car(new String[]{"leave","55","1625583886541","25840","5168","664482a016d1d5c563de606659b11d61","#bd6764","1","Company","Limousine","SU-T 87"});
        CarIF car4 = new Car(new String[]{"leave","55","1625583886541","25840","5168","664482a016d1d5c563de606659b11d61","#bd6764","1","Company","Limousine","SU-T 87"});
        CarIF car5 = new Car(new String[]{"leave","55","1625583886541","25840","5168","664482a016d1d5c563de606659b11d61","#bd6764","1","Company","Limousine","SU-T 87"});
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    @AfterEach
    void tearDown() {
        mModel = null;
        cars = null;
    }

    @Test
    void filterAmountOfType() {
        fail();
    }

    @Test
    void filterPercentagesOfType() {
        assertEquals(0L,mModel.filterPercentagesOfType(cars,"Day"));
        assertEquals(100L, mModel.filterPercentagesOfType(cars,"Company"));
    }
}