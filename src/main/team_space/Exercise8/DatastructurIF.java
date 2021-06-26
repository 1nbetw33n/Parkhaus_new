package Exercise8;

import java.util.List;

interface DatastructurIF {

      //Erzeugt einen neuen Iterator
      public IteratorIF erzeugeIterator(List<Integer> zahlen,String choice)throws IllegalArgumentException;

}
