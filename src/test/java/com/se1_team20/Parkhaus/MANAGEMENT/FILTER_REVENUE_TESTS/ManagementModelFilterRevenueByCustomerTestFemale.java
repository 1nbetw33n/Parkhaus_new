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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ManagementModelFilterRevenueByCustomerTestFemale extends ManagementModelTest {

    /* TESTS FOR FEMALE */

    @Test
    @DisplayName("filterRevenue for female - equals test")
    void handicappedEqualsTestFilterRevenue()
    {
        assertEquals(0.0,  ManagementModel.filterRevenueByCustomer(new ArrayList<>(), "Female"));
        assertEquals(5168. * 2.,  ManagementModel.filterRevenueByCustomer(this.cars, "Female"));
    }

    @Test
    @DisplayName("filterRevenue for female - not equals test")
    void handicappedNotEqualsTestFilterRevenue()
    {
        assertNotEquals(5168. * 3, ManagementModel.filterRevenueByCustomer(new ArrayList<>(), "Female"));
        assertNotEquals(5168. * 1, ManagementModel.filterRevenueByCustomer(this.cars, "Female"));
    }

    @Test
    @DisplayName("filterRevenue for female - not null test")
    void handicappedNotNullTestFilterRevenue()
    {
        assertNotNull(ManagementModel.filterRevenueByCustomer(new ArrayList<>(), "Female"));
        assertNotNull(ManagementModel.filterRevenueByCustomer(this.cars, "Female"));
    }
    
}
