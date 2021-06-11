package Exercise8.PartielleOrdnung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TopSortIterator implements java.util.Iterator<String>{

    public String[][]arr;
    List<String> strings=new ArrayList<>();
    StringSortImpl sort;
    public int index=0;
    List<String> temp= new ArrayList<>();

    public TopSortIterator(String[][]arr){

        this.arr=arr;

        sort=new StringSortImpl(arr);

        //From multidimensional to single dimensional array
        for(int i=0;i< arr.length;i++){

            for(int j=0;j<arr[i].length;j++){

                strings.add(arr[i][j]);
            }
        }

    }

    @Override
    public String next() throws IllegalArgumentException {

        if(index!=0){

            while(temp.contains(strings.get(index))){

                if(index<strings.size()) {

                    strings.remove(index);
                }
                {

                }
            }

        }

        temp.add(strings.get(index));

        String[]zwischenspeicher=new String[temp.size()];

        zwischenspeicher=temp.toArray(zwischenspeicher);

        while(!sort.isWellSorted(zwischenspeicher)){

            //index++;
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
