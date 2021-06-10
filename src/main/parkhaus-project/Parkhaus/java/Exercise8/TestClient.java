package Exercise8;

import java.util.Arrays;
import java.util.List;

public class TestClient {

    public static void main(String[]args) throws IllegalArgumentException {


        ZahlenListe digits=new ZahlenListe();

        //Eine Liste von Zahlen erzeugen.
        List<Integer>zahlen= Arrays.asList(33,46,12,78,23,34,99);

        //Zahlen zur Liste hinzufuegen.

        IteratorIF iter= digits.erzeugeIterator(zahlen,"Hallo");

        while(iter.hasnext()){

            int elem=iter.next();

            new ZahlenListe().print(elem);
        }

    }
}
