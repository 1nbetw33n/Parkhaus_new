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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashUniTest {

    private Long                   counter;
    private  Student             stud1;
    private  Student             stud2;
    private  Student             stud3;
    private  Kurs                  kurs1;
    private  Kurs                  kurs2;
    private  Kurs                  kurs3;
    private Kurs[]                kurse;
    private Student[]           studs;
    private CashUni             cashUni;

    @BeforeEach
    void setUp() {
        this.counter   = 0L;
        this.kurs1      = new Kurs(true, 6, 200);
        this.kurs2      = new Kurs(true, 9, 300);
        this.kurs3      = new Kurs(false, 3,100);
        this.stud1      = new Student(true, new Kurs[]{this.kurs1, this.kurs2, this.kurs3});
        this.stud2      = new Student(true, new Kurs[]{this.kurs1});
        this.stud3      = new Student(false, new Kurs[]{this.kurs1, this.kurs3});
        this.kurse      = new Kurs[]{this.kurs1, this.kurs2, this.kurs3};
        this.studs      = new Student[]{this.stud1, this.stud2, this.stud3};
        this.cashUni  = new CashUni(this.kurse, this.studs);
    }

    @AfterEach
    void tearDown() {
        this.counter  = null;
        this.stud1     = null;
        this.stud2     = null;
        this.stud3     = null;
        this.kurs1     = null;
        this.kurs2     = null;
        this.kurs3     = null;
        this.cashUni =  null;
        this.kurse     = null;
        this.studs     = null;
    }

    @Test
    void sumKurse() {
    }

    @Test
    @DisplayName("tests CashUni.sumStuds()")
    /* tests if, this returns correctly the sum of all course costs of all working students */
    void sumStuds() {
        assertEquals(800, this.cashUni.sumStuds(), "That's not working like it should! Try Again:) -"  + ++this.counter);
    }

    @Test
    void avg() {
    }
}