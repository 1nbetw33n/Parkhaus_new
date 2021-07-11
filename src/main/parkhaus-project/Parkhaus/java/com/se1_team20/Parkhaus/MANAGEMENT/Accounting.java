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
import java.util.function.Predicate;

public class Accounting {

    private static Accounting instance;

    private static final List<HashMap<String, String>> BILLS = new ArrayList<>();


    //TODO: TEST THIS STUFF (ONLY ONE INSTANCE POSSIBLE AND DEFAULT BILL)
    /* every time a new instance is created, this block will be executed (only 1 instance possible) */
    static
    {
        try
        {
            instance = getInstance();
            final HashMap<String, String> bill = new HashMap<>();
            bill.put("Management", "easy-pass-word");
            BILLS.add(bill);
        }
        catch (final Exception E)
        {
            throw new RuntimeException("Only one instance possible.");
        }
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


    //TODO: WRITE TESTS FOR THIS UNIT
    @SuppressWarnings("unchecked")
    private boolean checkBills(@NotNull final HashMap<String, String> MAP)
    {
        return BILLS.stream()
                .anyMatch((Predicate<? super HashMap<String, String>>) MAP);
    }

}
