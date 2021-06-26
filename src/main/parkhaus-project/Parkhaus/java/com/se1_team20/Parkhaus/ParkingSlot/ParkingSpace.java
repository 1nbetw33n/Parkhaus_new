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

package com.se1_team20.Parkhaus.ParkingSlot;

import java.util.Random;

public abstract class ParkingSpace {

     public boolean ishandicap=false;

     public ParkingSpace(){

         Random rnd=new Random();

         this.ishandicap=rnd.nextBoolean();
     }

     public ParkingSpace(boolean value){

         this.ishandicap=value;
     }




}
