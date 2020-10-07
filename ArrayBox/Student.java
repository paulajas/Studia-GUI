package Zadanie_10;

import java.lang.Comparable;

public class Student extends Osoba{

    private int eska;

    public Student (String nazwisko, int wiek, int eska){
        super(nazwisko, wiek);
        this.eska = eska;
    }

    public int compareTo(Student s) {
        if (super.compareTo(s) ==0)
            return this.eska-s.eska;
        else
            return super.compareTo(s);
    }

    @Override
    public String toString() {
        return super.toString () + " eska " + eska;
    }

    /*
    public int compareTo(Osoba s) {
        if (super.compareTo(s) ==0)
         compareTo
    }

     */
}
