package GUI8;

public class Prostokat2 extends Prostokat implements Obliczenie, Rysowanie {

    protected char znak;

    public Prostokat2(int x, int y, int w, int h, char znak) {
        super(x, y, w, h);
        this.znak = znak;
    }

    @Override
    public void rysuj() {
        for (int i=0; i < getH(); i++){      //pętla rysująca prostokąt (pętla w pętli po wysokości i szerokości
            for (int j=0; j < getW(); j++)
                System.out.print(znak);
            System.out.println();
        }

    }
}
