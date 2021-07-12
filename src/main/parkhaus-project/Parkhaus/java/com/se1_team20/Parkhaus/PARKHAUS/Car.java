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

    private String[] params;


    public Car( String[] params ) { this.params = params; }

    @Override
    public int nr()
    {
        return Integer.parseInt(params[1]);
    }

    public String licensePlate(){return this.params[10];}

    @Override
    public long begin()
    {
        return params[0].equals("enter") ? Long.parseLong(params[2]) : end()-duration();
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public long end()
    {
        return (this.params[0].equals("leave")) ?  Long.parseLong(params[2]) : 0;
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public int duration()
    {
        return  (this.params[0].equals("leave")) ? Integer.parseInt(params[3]) : 0;
    }

    @Override
    // Now returns 0 if the car hasnt left yet
    public int price()
    {
        if (this.kunde().equals("Company")) return 0;
        return (this.params[0].equals("leave")) ? Integer.parseInt(this.params[4]) : 0;
    }

    public String hash() {
        return this.params[5];
    }

    public int space() {return Integer.parseInt(this.params[7]);}

    public String kunde(){ return this.params[8];}

    public String typeCar() { return this.params[9];}

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (String value: params) {
            if (value == params[0]) {
                // DO Nothing, eg. dont print enter of leave
            } else if (value == params[1]) {
                builder.append(value);
            } else {
                builder.append("/" + value);
            }
        }
        return builder.toString();
    }
}
