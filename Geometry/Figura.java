package GUI8;

public abstract class Figura implements Obliczenie, Comparable<Figura> {

    //położenie lew górnego rogu figury
    protected int x;
    protected int y;
    private static int num=1;
    protected int id;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
        this.id=num++;
    }

    @Override
    public int compareTo(Figura f) {
        if (this.pole()>f.pole())
            return 1;
        else if (this.pole()==f.pole()){
            if (this.obwod()>f.obwod())
                return 1;
            else if (this.obwod()==f.obwod())
                if (this.id > f.id)
                    return 1;
                else
                    return -1;
            else
                return -1;
        }
        return -1;
    }

    //abstracyjna bo nie znamy nazwy
    public abstract String nazwa();
    //
    public abstract String toString();
    //też abstracyjna bo pobiera dwie liczby, w klasie pochodnej def
    public abstract void pozycja (int x, int y);
}
