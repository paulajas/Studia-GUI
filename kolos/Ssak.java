package kolos;

public class Ssak extends Zwierze {
    protected int wiek;

    public Ssak(String gatunek, String gdzieZyje, int wiek) {
        super ( gatunek, gdzieZyje );
        this.wiek = wiek;
    }

    public int compareTo(Zwierze s) {
        if (this.porownanie(s) == 0 && s instanceof Ssak){
            if (this.wiek == ((Ssak)s).wiek){
                return super.compareTo ( s );
            }
            else
                return this.wiek-((Ssak)s).wiek;
        }
        else
            return this.porownanie ( s );
    }

    @Override
    public String toString() {
        return "Ssak" +
                "wiek " + wiek +
                ", gatunek '" + gatunek +
                ", zyje " + gdzieZyje +
                ", nr " + nr;
    }
}
