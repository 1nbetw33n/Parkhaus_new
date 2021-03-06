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
10.Jul.2021
*/

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Accounting {

    private static Accounting instance;

    private static final List<HashMap<String, String>> BILLS = new ArrayList<>();

    /* every time a new instance is created, this block will be executed (only 1 instance possible) */
    static
    {
            instance = getInstance();
            final HashMap<String, String> bill = new HashMap<>();
            bill.put("Management", "Easy-pass-w0rd");
            BILLS.add(bill);
    }

    private Accounting(){}

    /* makes this thing double-thread-safe */
    public static synchronized Accounting getInstance()
    {
        if (instance == null)
        {
            synchronized (Accounting.class)
            {
                if (instance == null)
                {
                    instance = new Accounting();
                }
            }
        }
        return instance;
    }

    public boolean checkBILLS(@NotNull final String KEY, @NotNull final String VALUE)
    {
        return BILLS.stream()
                    .filter(x -> x.containsKey(KEY))
                        .anyMatch(x -> x.containsValue(VALUE));
    }

    List<HashMap<String, String>> getBILLS() {
        return BILLS;
    }

}
