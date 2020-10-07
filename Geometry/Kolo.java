package GUI8;

public class Kolo extends Figura {

    //promien kola
    protected int r; //promien

    public Kolo(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public String nazwa() {
        return "Kolo";
    } //nazwa typu

    @Override
    public String toString() {
        return nazwa() + "\n" + "Srodek - (" + x + "," + y + ") \n" + "Promien -" + r +"\n";
    }

    @Override
    public void pozycja(int x, int y) {
        double odl_X = Math.abs(this.x-x); //współrzedna x do równania pitagorasa
        double odl_Y= Math.abs(this.y-y); //współrzędna y do równania pitagorasa
        double odl_od_r=Math.sqrt(Math.pow(odl_X,2)+Math.pow(odl_Y,2)); //piagoras i z tego odległość punktu od środka koła
        if(odl_od_r<=r) //warunek by punkt leżał w kole
            System.out.println("Punkt (" + x + ","+ y + ") znajduje sie wewnatrz kola");
        else
            System.out.println("Punkt (" + x +"'"+ y + ") znajduje sie na zewewnatrz kola.");
    }

    @Override
    public double pole() {
        return pi*Math.pow(r,2); //wzor na pole
    }

    @Override
    public double obwod() {
        return 2*pi*r; // wzor na obwod
    }
}

