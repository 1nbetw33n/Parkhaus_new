package Exercise8.PartielleOrdnung;

import java.util.Iterator;

class PartialOrdering implements Iterable<String> {

    private final String[][] order;

    public PartialOrdering(String[][] order){
        this.order = order;
    }

    public Iterator<String> iterator(){
        return (Iterator<String>) new TopSortIterator( this.order );
    }

    public static PartialOrdering studentLife(){
        return new PartialOrdering(new String[][]{
                {"Aufstehen", "Frühstücken"},
                {"Aufstehen", "KaffeeTrinken"},
                {"Frühstücken", "Lernen"},
                {"KaffeeTrinken", "Lernen"}
        });
    }

    public static void main(String[] args) {
        for ( String step : studentLife() ) {
            System.out.println( step );
        }
    }
}
