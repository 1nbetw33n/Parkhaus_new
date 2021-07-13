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

public class ManagementModelFilterRevenueByCustomerTestCompany extends ManagementModelTest {
    
    /* TESTS FOR COMPANY */

    @Test
    @DisplayName("filterRevenue for company - equals test")
    void companyEqualsTestFilterRevenue()
    {
        assertEquals(0.,  mModel.filterRevenueByCustomer(new ArrayList<>(), "Company"));
        assertEquals(0.,  mModel.filterRevenueByCustomer(this.cars, "Company"));
    }

    @Test
    @DisplayName("filterRevenue for company - not equals test")
    void companyNotEqualsTestFilterRevenue()
    {
        assertNotEquals(5168. * 5., mModel.filterRevenueByCustomer(new ArrayList<>(), "Company"));
        assertNotEquals(5168. * 5., mModel.filterRevenueByCustomer(this.cars, "Company"));
    }

    @Test
    @DisplayName("filterRevenue for company - not null test")
    void companyNotNullTestFilterRevenue()
    {
        assertNotNull(mModel.filterRevenueByCustomer(new ArrayList<>(), "Company"));
        assertNotNull(mModel.filterRevenueByCustomer(this.cars, "Company"));
    }

}
