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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashUniTest {

    private Long counter;
    private  Student   stud1;
    private  Student   stud2;
    private  Student   stud3;
    private  Kurs        kurs1;
    private  Kurs        kurs2;
    private  Kurs        kurs3;
    private List<Kurs> kurse;
    private List<Student> studs;
    private  CashUni cashUni;

    @BeforeEach
    void setUp() {
        this.counter = 0L;
        this.kurs1  = new Kurs(true, 6, 200);
        this.kurs2  = new Kurs(true, 9, 300);
        this.kurs3  = new Kurs(false, 3,100);
        this.stud1  = new Student(true, List<Kurs>(this.kurs1, this.kurs2, this.kurs3));
        this.stud2  = new Student(true, List<Kurs>(this.kurs1));
        this.stud3  = new Student(false,List<Kurs>(this.kurs1, this.kurs3));
        this.kurse  = List<>(this.kurs1, this.kurs2, this.kurs3);
        this.studs  = List<>(this.stud1, this.stud2, this.stud3);
        this.cashUni  = new CashUni(this.kurse, this.studs);
    }

    @AfterEach
    void tearDown() {
        this.counter = null;
        this.stud1    = null;
        this.stud2    = null;
        this.stud3    = null;
        this.kurs1  = null;
        this.kurs2  = null;
        this.kurs3  = null;
        this.cashUni =  null;
        this.kurse = null;
        this.studs = null;
    }

    @Test
    void sumKurse() {
    }

    @Test
    void sumStuds() {
        assertEquals(0, 0, "That's not working like it should! Try Again:) -"  + ++this.counter);
    }

    @Test
    void avg() {
    }
}