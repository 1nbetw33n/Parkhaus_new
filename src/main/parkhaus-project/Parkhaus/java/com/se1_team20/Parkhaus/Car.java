package com.se1_team20.Parkhaus;

import java.util.Arrays;

public class Car implements CarIF {

    String[] params;

    public Car( String[] params )
    {
        this.params = params;
    }

    @Override
    public int nr()
    {
        return Integer.parseInt(params[1]);
    }

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
        return (this.params[0].equals("leave")) ? Integer.parseInt(this.params[4]) : 0;
    }


    @Override
    public String toString(){
        return Arrays.toString( params );
    }
}
