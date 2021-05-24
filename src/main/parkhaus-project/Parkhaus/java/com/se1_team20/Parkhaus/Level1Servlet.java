package com.se1_team20.Parkhaus;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "level1Servlet", value = "/level1-servlet")
public class Level1Servlet extends ParkhausServlet {

    @Override
    String getNAME(){
        return "Level1";
    }

    @Override
    int getMAX(){ // maximum number of parking slots on level 1
        return 11;
    }

    @Override
    String getCONFIG(){
        return ""; // use default config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
        // e.g. return this.MAX() + ",5,23,100,10";  // TODO replace by your own parameters
    }



}