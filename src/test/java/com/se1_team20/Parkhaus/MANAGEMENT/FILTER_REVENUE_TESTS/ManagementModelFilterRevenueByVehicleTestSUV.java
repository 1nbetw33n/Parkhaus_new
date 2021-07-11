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

package com.se1_team20.Parkhaus.MANAGEMENT.FILTER_REVENUE_TESTS;
/*
1nbetw33n
11.Jul.2021
*/

import com.se1_team20.Parkhaus.MANAGEMENT.ManagementModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagementModelFilterRevenueByVehicleTestSUV extends ManagementModelTest {

    /* TESTS FOR SUV */

    @Test
    @DisplayName("filterRevenue for Limousine - equals test")
    void suvEqualsTestFilterRevenue()
    {
        assertEquals(0.,  mModel.filterRevenueByVehicle(new ArrayList<>(), "Limousine"));
        assertEquals(0.,  mModel.filterRevenueByVehicle(this.cars, "SUV"));
    }

    @Test
    @DisplayName("filterRevenue for SUV - not equals test")
    void suvNotEqualsTestFilterRevenue()
    {
        assertNotEquals(5168., mModel.filterRevenueByVehicle(new ArrayList<>(), "SUV"));
        assertNotEquals(0, mModel.filterRevenueByVehicle(this.cars, "SUV"));
        assertNotEquals(5168. * 2., mModel.filterRevenueByVehicle(this.cars, "SUV")):
    }

    @Test
    @DisplayName("filterRevenue for SUV - not null test")
    void suvNotNullTestFilterRevenue()
    {
        assertNotNull(mModel.filterRevenueByVehicle(new ArrayList<>(), "SUV"));
        assertNotNull(mModel.filterRevenueByVehicle(this.cars, "SUV"));
    }

}
