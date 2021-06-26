package Exercise8.PartielleOrdnung;

import Exercise8.IllegalArgumentException;

public interface Iterator<String> {

    public String next() throws IllegalArgumentException;
    public boolean hasnext();
}
