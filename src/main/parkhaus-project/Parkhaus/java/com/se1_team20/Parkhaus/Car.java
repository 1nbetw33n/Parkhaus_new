package com.se1_team20.Parkhaus;

import java.util.Arrays;

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
        return Long.parseLong(params[2]);
    }

    @Override
    public int duration()
    {
        return Integer.parseInt(params[3]);
    }

    @Override
    public int price()
    {
        return Integer.parseInt(this.params[4]);
    }

    @Override
    public String toString(){
        return Arrays.toString( params );
    }
}
