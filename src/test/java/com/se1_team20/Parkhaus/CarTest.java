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

package com.se1_team20.Parkhaus;

import com.se1_team20.Parkhaus.CheckoutDir.CheckoutModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car carEnter = new Car(null);
    private Car carLeave = new Car(null);

    @BeforeEach
    void setUp() {
        carEnter = new Car(new String[]{"enter,173,1624278150403,_,_,8319c7d02f8b786e4f1a231af06da0c7,#714934,7,_,_,173"});
        carLeave = new Car(new String[]{"leave,173,1624278155427,5018,502,8319c7d02f8b786e4f1a231af06da0c7,#714934,6,_,_,173"});
    }

    @AfterEach
    void tearDown() {
        carEnter = null;
        carLeave = null;
    }
    @Test
    void nr() {
    }

    @Test
    void begin() {
    }

    @Test
    void end() {
    }

    @Test
    void duration() {
    }

    @Test
    void price() {
    }

    @Test
    void testToString() {
    }
}