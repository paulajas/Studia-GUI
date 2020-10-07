package zadanie_19;

public class Mathematic {
    private double a;
    private double b;
    private double c;

    public Mathematic (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println ("a = " + a + " b = " + b + " c = " +c );
    }

    private double delta(){
        double delta = (Math.pow ( b, 2 )) - (double)(4*a*c);
        return delta;
    }

    boolean isAvailable(){
        double delta=delta();
        if (delta >= 0 )
            return true;
        else
            return false;
    }

    String wyniki(){
        double delta = delta();
        if (delta == 0){
            double wynik = (-b)/(2*a);
            return "x = " + wynik;
        }
        else if(delta > 0){
            double wynik1 = (-b-delta)/(2*a);
            double wynik2 = (-b+delta)/(2*a);
            return "x1 = " + wynik1 + ", x2 = " + wynik2;
        }
        else {
            return "complex numbers are not for me";
        }
    }

}
