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
09.Jul.2021
*/

import com.se1_team20.Parkhaus.MANAGEMENT.ManagementModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ManagementModelFilterRevenueByCustomerTestDay extends ManagementModelTest {

    /* TESTS FOR DAY */

    @Test
    @DisplayName("filterRevenue for day - equals test")
    void dayEqualsTestFilterRevenue()
    {
        assertEquals(0.0,  mModel.filterRevenueByCustomer(new ArrayList<>(), "Day"));
        assertEquals(5168. * 3.,  mModel.filterRevenueByCustomer(this.cars, "Day"));
    }

    @Test
    @DisplayName("filterRevenue for day - not equals test")
    void dayNotEqualsTestFilterRevenue()
    {
        assertNotEquals(5168. * 3, mModel.filterRevenueByCustomer(new ArrayList<>(), "Day"));
        assertNotEquals(0., mModel.filterRevenueByCustomer(this.cars, "Day"));
    }

    @Test
    @DisplayName("filterRevenue for day - not null test")
    void dayNotNullTestFilterRevenue()
    {
        assertNotNull(mModel.filterRevenueByCustomer(new ArrayList<>(), "Day"));
        assertNotNull(mModel.filterRevenueByCustomer(this.cars, "Day"));
    }

}
