package Exercise8.PartielleOrdnung;

import Exercise8.IllegalArgumentException;

import java.util.LinkedList;
import java.util.List;

class TopSortIterator implements java.util.Iterator<String>{

    public String[][]arr;
    StringSortImpl sort;
    public int index=0;
    List<String> strings= new LinkedList<>();
    List<String> temp= new LinkedList<>();

    public TopSortIterator(String[][]arr){

        this.arr=arr;

        sort=new StringSortImpl(arr);

        //From multidimensional to single dimensional array
        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr[0].length;j++){

                strings.add(arr[i][j]);
            }
        }

    }


    /* generic next() method */
    /*
    public String next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return temp.get(index++);
    }
    */

    @Override
    public String next() {

        if(index!=0){

            while(temp.contains(strings.get(index))){

                strings.remove(index);
            }
        }

        temp.add(strings.get(index));

        String[]zwischenspeicher=new String[temp.size()];

        zwischenspeicher=temp.toArray(zwischenspeicher);

        while(true){
            try {
                if (sort.isWellSorted(zwischenspeicher)) break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            index++;
        }

        return temp.get(index++);
    }



    @Override
    public boolean hasNext() {

        return index<strings.size();
    }

    public void print(String value){

        System.out.println(value);
    }

}
