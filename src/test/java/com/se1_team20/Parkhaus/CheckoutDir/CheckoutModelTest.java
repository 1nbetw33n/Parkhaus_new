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

package com.se1_team20.Parkhaus.CheckoutDir;

import com.se1_team20.Parkhaus.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutModelTest {

    private CheckoutModel cm;
    private Car carEnter = new Car(null);
    private Car carLeave = new Car(null);

    @BeforeEach
    void setUp() {
        cm = new CheckoutModel();
        carEnter = new Car(new String[]{"enter","173","1624278150403","","","8319c7d02f8b786e4f1a231af06da0c7","#714934","7","_","_","173"});
        carLeave = new Car(new String[]{"leave","173","1624278155427","5018","502","8319c7d02f8b786e4f1a231af06da0c7","#714934","6","","","173"});
    }

    @AfterEach
    void tearDown() {
        cm = null;
        carEnter = null;
        carLeave = null;
    }

    @Test
    @DisplayName("Der Preis für ein geparktes Auto wird korrekt angezeigt")
    void kundenParkkostenTest() {
        assertEquals(502, cm.kundenParkkosten(carLeave));
    }
}