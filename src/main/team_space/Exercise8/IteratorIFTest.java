package Exercise8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IteratorIFTest {

    List<Integer> zahlen= Arrays.asList(33,46,12,78,23,34,99);
    ZahlenListe list=new ZahlenListe();
    IteratorIF eveniter;
    IteratorIF odditer;

    @BeforeEach
    @DisplayName("Creates a new Object of type IteratorIF.")
    void setUp() throws IllegalArgumentException {

        eveniter=list.erzeugeIterator(zahlen,"Even");
        odditer=list.erzeugeIterator(zahlen,"Odd");
    }

    @Test
    @DisplayName("Tests whether the next-method delivers even or odd numbers.")
    void testnext(){

        //Lets say I want to check whether the Iterator iterates through even numbers
        assertEquals(46,eveniter.next(),"Opps something is wrong!!");
        assertEquals(12,eveniter.next(),"Opps something is wrong!!");
        assertEquals(78,eveniter.next(),"Opps something is wrong!!");
        assertEquals(34,eveniter.next(),"Opps something is wrong!!");

        //Now the odd nummbers
        assertEquals(33,odditer.next(),"Opps something is wrong!!");
        assertEquals(23,odditer.next(),"Opps something is wrong!!");
        assertEquals(99,odditer.next(),"Opps something is wrong!!");


    }


}