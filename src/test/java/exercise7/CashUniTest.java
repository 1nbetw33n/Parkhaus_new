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

package exercise7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashUniTest {

    private Long counter;

    @BeforeEach
    void setUp() {
        this.counter = 0L;
    }

    @AfterEach
    void tearDown() {
        this.counter = null;
    }

    @Test
    void sumKurse() {
    }

    @Test
    void sumStuds() {
        assertEquals(0, 0, "That's not working like it should! -"  + ++this.counter);
    }

    @Test
    void avg() {
    }
}