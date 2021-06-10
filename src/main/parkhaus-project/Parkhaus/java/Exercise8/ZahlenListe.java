package Exercise8;

import java.util.*;

//Datastructur
public class ZahlenListe implements DatastructurIF{

    @Override
    //Returns a new Iterator
    public IteratorIF erzeugeIterator(List<Integer>zahlen,String wahl) throws IllegalArgumentException{

        if(wahl!="Even" && wahl!="Odd")
        {
            throw new IllegalArgumentException();
        }

        return new ZahlenIterator(zahlen,wahl);
    }

    //Prints the given value
    void print(int value){

        System.out.print(value+" ");
    }

}
