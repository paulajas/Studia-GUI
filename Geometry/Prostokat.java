package GUI8;

public class Prostokat extends Figura{

    protected int w; //szerokosc
    protected int h; //wysokosc

    public Prostokat(int x, int y, int w, int h) {
        super(x, y);
        this.h = h;
        this.w = w;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    @Override
    public String nazwa() {
        return "Prostokat";
    } //zwraca nazwę typu figury

    @Override
    public String toString() { //pobiera nazwę typu figury i wypisuje na konsoli dane
        return nazwa() + "\n" + "Lewy gorny - ( " + x + "," + y + ") \n" + "Szerokosc: " + w + " Wysokosc: " + h + "\n";
    }

    @Override
    public void pozycja(int x, int y) {
        if ((this.x <= x && x <= this.x + w) && (this.y <= y)&&(y<=this.y+h)) //warunki by sprawdzić czy punkt w kole "pure math"
            System.out.println("Punkt (" + x + ","+y + ") znajduje sie na zewewnatrz prostokata");
        else
        System.out.println("Punkt (" + x + ","+y + ") znajduje sie wewnatrz prostokata");
    }

    @Override
    public double pole() {
        return h*w; //wzor na pole
    }

    @Override
    public double obwod() {
        return (2*h+2*w); //wzor na obwod
    }
}
