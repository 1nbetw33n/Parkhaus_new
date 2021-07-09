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

import com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel;
import com.se1_team20.Parkhaus.MANAGEMENT.ManagementModelTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementModelFilterRevenueByCustomerTestFemale extends ManagementModelTest {

    /* TESTS FOR FEMALE */

    @Test
    @DisplayName("filterRevenue for female - equals test")
    void handicappedEqualsTestFilterRevenue()
    {
        Assertions.assertEquals(0.0, ManagementModel.filterRevenueByCustomer(this.cars, "CUSTOMERTYPE"));;
    }

    @Test
    @DisplayName("filterRevenue for female - not equals test")
    void handicappedNotEqualsTestFilterRevenue()
    {
        assertEquals(0.0, ManagementModel.filterRevenueByCustomer(this.cars, "CUSTOMERTYPE"));;
    }

    @Test
    @DisplayName("filterRevenue for female - null test")
    void handicappedNullTestFilterRevenue()
    {
        assertEquals(0.0, ManagementModel.filterRevenueByCustomer(this.cars, "CUSTOMERTYPE"));;
    }

    @Test
    @DisplayName("filterRevenue for female - not null test")
    void handicappedNotNullTestFilterRevenue()
    {
        assertEquals(0.0, ManagementModel.filterRevenueByCustomer(this.cars, "CUSTOMERTYPE"));;
    }
    
}
