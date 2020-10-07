package Zadanie_10;

public class Osoba implements Comparable<Osoba>{

    private String nazwisko;
    private int wiek;

    public Osoba( String nazwisko, int wiek){
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + nazwisko + ", wiek " + wiek;
    }

    public int compareTo(Osoba o) {
        if(this.nazwisko.compareTo(o.nazwisko) == 0)
            return (this.wiek-o.wiek);
        return this.nazwisko.compareTo(o.nazwisko);
    }
}
