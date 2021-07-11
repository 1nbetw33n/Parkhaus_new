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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountingTest {

    Accounting accounting;
    List<HashMap<String, String>> bills;
    HashMap<String, String> bill;


    @SuppressWarnings("unchecked")
    @BeforeEach
    void setUp()
    {
        this.accounting = Accounting.getInstance();
        this.bills = this.accounting.getBILLS();
        this.bill = new HashMap<>();
        this.bill.put("Management", "easy-pass-word");
    }

    @AfterEach
    void tearDown()
    {
        this.accounting = null;
        this.bills = null;
        this.bill = null;
    }

    @Test
    @DisplayName("singleton test assert same")
    void assertSameSingletonTest()
    {
        assertSame(this.accounting,  Accounting.getInstance());
    }

    @Test
    @DisplayName("BILLS successfully stores init bill")
    void storageTestBILLS()
    {
        assertEquals("[{Management=easy-pass-word}]", this.bills.toString());
    }

    @Test
    @DisplayName("checkBILLS assert true test")
    void assertTrueTestCheckBILLS()
    {
        assertTrue(this.accounting.checkBILLS("Management", "easy-pass-word"));
    }

    @Test
    @DisplayName("checkBILLS assert false test")
    void assertFalseTestCheckBILLS()
    {
        assertFalse(this.accounting.checkBILLS("ilrajeez", "132980mDSjDdjuiG452"));
        assertFalse(this.accounting.checkBILLS("superUSER123", "sUpEr-DuP-eRs-AfEPaSsW-0Rd"));
        assertFalse(this.accounting.checkBILLS("studi00", "12345ABCDE"));
    }

}