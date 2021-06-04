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

import java.util.Arrays;
import java.util.List;

public class CashUni {

    List<Kurs> kurse;
    List<Student> studs;

    public CashUni(Kurs[] kurse, Student... studs){
        this.kurse = Arrays.asList(kurse);
        this.studs = Arrays.asList(studs);
    }

    public int sumKurse(){
        return kurse.stream()
                .mapToInt(x -> x.gebühr)
                .reduce(0, Integer::sum);
    }

    public int sumStuds(){
        return studs.stream()
                .filter(x -> x.istBerufstätig)
                .mapToInt(x -> x.kurse.stream()
                        .map(y -> y.gebühr)
                        .reduce(0, Integer::sum))
                                .reduce(0, Integer::sum);
    }

    public double avg(){
        return kurse.stream()
                .filter(x -> x.ECTS > 5)
                .mapToDouble(x -> x.gebühr)
                .map(x -> x / kurse.stream()
                                            .filter(y -> y.ECTS > 5)
                                            .count())
                                                    .reduce(0, Double::sum);
    }

}
