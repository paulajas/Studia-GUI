package kolos;

public class Plaz extends Zwierze {
    protected double w; //srednia dl. plaza

    public Plaz(String gatunek, String gdzieZyje, double w) {
        super ( gatunek, gdzieZyje );
        this.w=w;
    }


    public int compareTo(Zwierze s) {
        if (this.porownanie(s) == 0 && s instanceof Plaz){
            if (this.w == ((Plaz)s).w){
                return super.compareTo ( s );
            }
            else
                return (int)(this.w-((Plaz)s).w);
        }
        else
            return this.porownanie ( s );
    }

    @Override
    public String toString() {
        return "Plaz{" +
                "w=" + w +
                ", gatunek='" + gatunek + '\'' +
                ", gdzieZyje='" + gdzieZyje + '\'' +
                ", nr=" + nr +
                '}';
    }
}
