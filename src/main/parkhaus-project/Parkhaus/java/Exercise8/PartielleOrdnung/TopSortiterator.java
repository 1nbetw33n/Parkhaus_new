package Exercise8.PartielleOrdnung;

import java.util.Arrays;
import java.util.List;

class TopSortIterator implements Iterator<String>{

    public String[][]arr;
    public String[]strings;
    StringSortImpl sort;
    public int index=0;
    List<String> temp= Arrays.asList();

    public TopSortIterator(String[][]arr){

        this.arr=arr;

        strings=new String[arr.length*2];

        sort=new StringSortImpl(arr);

        //From multidimensional to single dimensional array
        for(int i=0;i< arr.length;i++){

            for(int j=0;j<arr[0].length;j++){

                strings[i]=arr[i][j];
            }
        }

    }

    @Override
    public String next() throws IllegalArgumentException {

        if(index!=0){

            while(temp.contains(strings[index])){

                index++;
            }
        }

        temp.add(strings[index]);

        String[]zwischenspeicher=new String[temp.size()];

        zwischenspeicher=temp.toArray(zwischenspeicher);

        while(!sort.isWellSorted(zwischenspeicher)){

            index++;
        }

        return temp.get(index++);
    }

    @Override
    public boolean hasnext() {
        return false;
    }

}
