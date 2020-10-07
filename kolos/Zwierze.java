package kolos;

public class Zwierze implements Comparable<Zwierze>{
    protected String gatunek;
    protected String gdzieZyje;
    protected int nr;
    static private int unikalnyNr;

    public Zwierze(String gatunek, String gdzieZyje) {
        this.gatunek = gatunek;
        this.gdzieZyje = gdzieZyje;
        this.nr = unikalnyNr;
        unikalnyNr++;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "gatunek='" + gatunek + '\'' +
                ", gdzieZyje='" + gdzieZyje + '\'' +
                ", nr=" + nr +
                '}';
    }

    protected int porownanie(Zwierze z){
        if (Integer.parseInt(this.gatunek.toLowerCase ()) > Integer.parseInt (z.gatunek.toLowerCase ()))
            return 1;
        else if(Integer.parseInt(this.gatunek.toLowerCase ()) == Integer.parseInt (z.gatunek.toLowerCase ())){
            if (Integer.parseInt(this.gdzieZyje.toLowerCase ()) > Integer.parseInt (z.gdzieZyje.toLowerCase ()))
                return 1;
            else if (Integer.parseInt ( this.gdzieZyje.toLowerCase () ) == Integer.parseInt ( z.gdzieZyje.toLowerCase () )) {
                return 0;
            }else
                return -1;
        }else
            return -1;
    }

    @Override
    public int compareTo(Zwierze z) {
        if (this.porownanie ( z ) == 0){
            if (nr > z.nr)
                return 1;
            else
                return -1;
        }
        return 0;
    }
}
