public class ReversibleInt implements Reversible {

    public int numer;

    public ReversibleInt (int numer){
        this.numer = numer;
    }

    @Override
    public String toString() {
        return String.valueOf(numer);
    }

    @Override
    public Reversible reverse() {
        this.numer=-numer;
        Reversible rev = new ReversibleInt(numer);
    return rev ;
    }
}
