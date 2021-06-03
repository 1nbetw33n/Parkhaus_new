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

package exercise7;

public class Kurs {

    protected boolean hatZertifikat;
    protected  int ECTS;
    public int gebühr;

    public Kurs(boolean zertifikat, int ects, int gebühr){
        this.hatZertifikat = zertifikat;
        this.ECTS = ects;
        this.gebühr = gebühr;
    }

}
