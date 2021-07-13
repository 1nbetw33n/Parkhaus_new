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
/*Bearbeitet von ganzem Team */

package com.se1_team20.Parkhaus.PARKHAUS;

public class Car implements CarIF {

    private final String[] PARAMS;


    public Car( String[] params )
    {
        this.PARAMS = params;


    }



    @Override
    public int nr()
    {
        return Integer.parseInt(PARAMS[1]);
    }

    public String licensePlate(){return this.PARAMS[10];}

    @Override
    public long begin()
    {
        return PARAMS[0].equals("enter") ? Long.parseLong(PARAMS[2]) : end()-duration();
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public long end()
    {
        return (this.PARAMS[0].equals("leave")) ?  Long.parseLong(PARAMS[2]) : 0;
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public int duration()
    {
        return  (this.PARAMS[0].equals("leave")) ? Integer.parseInt(PARAMS[3]) : 0;
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public int price()
    {
        if (this.kunde().equals("Company")) return 0;
        return (this.PARAMS[0].equals("leave")) ? Integer.parseInt(this.PARAMS[4]) : 0;
    }

    public String hash() {
        return this.PARAMS[5];
    }

    public int space() {return Integer.parseInt(this.PARAMS[7]);}

    public String kunde(){ return this.PARAMS[8];}

    public String typeCar() { return this.PARAMS[9];}

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (String value: PARAMS) {
            if (value.equals(PARAMS[0])) {
                // DO Nothing, eg. dont print enter of leave
            } else if (value.equals(PARAMS[1])) {
                builder.append(value);
            } else {
                builder.append("/")
                       .append(value);
            }
        }
        return builder.toString();
    }
}
