package Exercise8.PartielleOrdnung;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[]args) throws IllegalArgumentException {


        String[][]arr={{"Aufstehen","Frühstücken"},{"Aufstehen","KaffeeTrinken"},{"Frühstücken","Lernen"},{"KaffeeTrinken","Lernen"}};


        PartialOrdering po=new PartialOrdering(arr);

        Iterator<String> iter =  po.iterator();

        TopSortIterator topsort=new TopSortIterator(arr);

        System.out.println(topsort.strings);

        while(iter.hasNext()){

             String temp= iter.next();

             topsort.print(temp);
        }







    }
}
