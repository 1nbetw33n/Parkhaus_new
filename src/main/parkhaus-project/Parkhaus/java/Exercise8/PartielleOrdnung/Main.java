package Exercise8.PartielleOrdnung;

import Exercise8.IllegalArgumentException;

public class Main {

    public static void main(String[]args) throws IllegalArgumentException {


        String[][]arr={{"Aufstehen","Frühstücken"},{"Aufstehen","KaffeeTrinken"},{"Frühstücken","Lernen"},{"KaffeeTrinken","Lernen"}};

        StringSortImpl s=new StringSortImpl(arr);


        String[]arr2={"Aufstehen"};
        System.out.println(s.isWellSorted(arr2));

        PartialOrdering po=new PartialOrdering(arr);

        Iterator<String>iter= (Iterator<String>) po.iterator();



        System.out.println(iter.next());




    }
}
