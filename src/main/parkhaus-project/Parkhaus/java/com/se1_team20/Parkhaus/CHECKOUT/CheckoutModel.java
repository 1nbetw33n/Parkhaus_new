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

package com.se1_team20.Parkhaus.CHECKOUT;
/*
1nbetw33n
06.Jul.2021
Klasse bearbeitet von Bella
*/

import com.se1_team20.Parkhaus.PARKHAUS.CarIF;
import com.sun.istack.internal.NotNull;
import java.util.List;

public class CheckoutModel {
    
    /* filters the car out, whose licensePlate matches the entered license plate or returns null, if there is no matching car in "former_cars" */
    public CarIF filterByLicensePlate(@NotNull final List<CarIF> CARS, @NotNull final String LICENSEPLATE)
    {
        return CARS.stream()
                .filter(x -> x.licensePlate().equals(LICENSEPLATE))
                        .findFirst()
                            .orElse(null);
    }

}
