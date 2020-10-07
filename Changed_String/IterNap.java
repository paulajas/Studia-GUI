import java.util.Iterator;

import java.util.Iterator;

public class IterNap
        implements Iterable<Character> {

    private String str;
    private int start = 0;
    private int krok = 1;

    public IterNap(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {

            public boolean hasNext() {
                return start < str.length();
            }

            public Character next() {
                int tmp = start;
                start += krok;
                return str.charAt(tmp);
            }
        };
    }
    public void ustawPoczatek(int i) {
        start = i;
    }

    public void ustawKrok(int i) {
        krok = i;
    }

}
