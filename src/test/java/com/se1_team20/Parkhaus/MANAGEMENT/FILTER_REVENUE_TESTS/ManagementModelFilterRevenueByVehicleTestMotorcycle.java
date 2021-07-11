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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementModelFilterRevenueByVehicleTestMotorcycle extends ManagementModelTest {

    //TESTS FOR MOTORCYCLE

    @Test
    @DisplayName("filterRevenue for Motorcycle - equals test")
    void motorcycleEqualsTestFilterRevenue()
    {
        assertEquals(0.,  mModel.filterRevenueByVehicle(new ArrayList<>(), "Motorcycle"));
        assertEquals(0.,  mModel.filterRevenueByVehicle(this.cars, "Motorcycle")); // expects 0., because the only motorcycle is a company customers
    }

}
