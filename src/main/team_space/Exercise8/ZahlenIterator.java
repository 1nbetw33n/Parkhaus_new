package Exercise8;

import java.util.Arrays;
import java.util.List;

public class ZahlenIterator implements IteratorIF{

      int index=0;
      List<Integer> zahlen= Arrays.asList();
      String wahl;                            //Even or Odd numbers

      //Constructor
      public ZahlenIterator(List<Integer>zahlen,String wahl){

          this.zahlen=zahlen;
          this.wahl=wahl;
      }


    @Override
    //Returns the next element.
    public int next() {

         if(wahl=="Even"){

             while(zahlen.get(index)%2!=0){

                   index++;
             }
         }
         else
         {
             while(zahlen.get(index)%2!=1){

                 index++;
             }
         }

         return zahlen.get(index++);

     }

    @Override
    //Checks whether the datastructur has further elements.
    public boolean hasnext() {

        return index<zahlen.size()-1;
    }

}
