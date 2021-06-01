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

package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutUnitTest {
/* TODO: IMPLEMENT TESTS */
    private Long counter;

    @BeforeEach
    void setUp(){
        this.counter = 0L;
    }


    @AfterEach
    void tearDown(){
        this.counter = null;
    }


    @Test
    @DisplayName("test, if the correct price is returned")
    void getPrice() {
        assertEquals(.0, .1, .0000000000001, "that's not working correctly. try smarter!:) - " + ++this.counter);
    }


    @Test
    @DisplayName("tests, if the correct bill number is returned")
    void getBillNumber(){
        assertEquals(0L, 1L, "that's not working correctly. try smarter!:) - " + ++this.counter);
    }


    @Test
    @DisplayName("tests, if the duration is returned correctly")
    void getDuration(){
        assertEquals(0L, 1L, "that's not working correctly. try smarter!: - " + ++this.counter);
    }
}