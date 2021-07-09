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
/*
1nbetw33n
09.Jul.2021
*/

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementModel_filterRevenueTest extends ManagementModelTest{

    @Test
    @DisplayName("filterRevenueByCustomerAndCar - equals test")
    public void equalsTestFilterRevenueByCustomerAndCar()
    {
        assertEquals(0.0, ManagementModel.filterRevenueByCustomerAndCar(this.cars, "CUSTOMERTYPE", "CARTYPE"));;
    }

    @Test
    @DisplayName("filterRevenueByCustomerAndCar - not equals test")
    public void notEqualsTestFilterRevenueByCustomerAndCar()
    {

    }

    @Test
    @DisplayName("filterRevenueByCustomerAndCar - null test")
    public void nullTestFilterRevenueByCustomerAndCar()
    {

    }

    @Test
    @DisplayName("filterRevenueByCustomerAndCar - not null test")
    public void notNullTestFilterRevenueByCustomerAndCar()
    {

    }

}
