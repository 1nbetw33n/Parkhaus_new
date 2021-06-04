package com.se1_team20.Parkhaus;

import java.util.Arrays;

// ToDo replace 0 by correct values read from this.params
public class Car implements CarIF {
    String[] params;
    public Car( String[] params ){
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
        return Long.parseLong(params[2]);
    }

    @Override
    public long end()
    {
        return 0;
    }

    @Override
    public int duration()
    {
        return 0;
    }

    @Override
    public int price()
    {
        return 0;
    }

    @Override
    public String toString(){
        return Arrays.toString( params );
    }
}
