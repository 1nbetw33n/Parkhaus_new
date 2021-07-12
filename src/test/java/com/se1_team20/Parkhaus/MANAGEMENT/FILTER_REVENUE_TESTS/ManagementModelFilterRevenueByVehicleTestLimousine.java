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

public class ManagementModelFilterRevenueByVehicleTestLimousine extends ManagementModelTest {

    //TESTS FOR LIMOUSINE

    @Test
    @DisplayName("filterRevenue for Limousine - equals test")
    void limousineEqualsTestFilterRevenue()
    {
        assertEquals(0.,  mModel.filterRevenueByVehicle(new ArrayList<>(), "Limousine"));
        assertEquals(6. * 5168.,  mModel.filterRevenueByVehicle(this.cars, "Limousine")); // expects 6. * 5168., because 2 of 8 limousines are company customers
    }

    @Test
    @DisplayName("filterRevenue for Limousine - not equals test")
    void limousineNotEqualsTestFilterRevenue()
    {
        assertNotEquals(5168., mModel.filterRevenueByVehicle(new ArrayList<>(), "Limousine"));
        assertNotEquals(0., mModel.filterRevenueByVehicle(this.cars, "Limousine"));
        assertNotEquals(5168. * 8., mModel.filterRevenueByVehicle(this.cars, "Limousine"));
    }

    @Test
    @DisplayName("filterRevenue for Limousine - not null test")
    void limousineNotNullTestFilterRevenue()
    {
        assertNotNull(mModel.filterRevenueByVehicle(new ArrayList<>(), "Limousine"));
        assertNotNull(mModel.filterRevenueByVehicle(this.cars, "Limousine"));
    }

}
