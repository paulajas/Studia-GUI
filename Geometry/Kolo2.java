package GUI8;

public class Kolo2 extends Kolo implements Transformacja{

    public final int x2 = getX(); //zmienne dodatkowe których nie można zmienić i pozwalają na zapisanie pierwotnego miejsca koła
    public final int y2=getY();

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    @Override
    public void przesunDo(int x, int y) { //przesuwa środek koła w punkt x,y
        setX(x);
        setY(y);
    }

    @Override
    public void powrot() { //ustawia pozycję koła na pierwotną
        setX(x2);
        setY(y2);

    }
}
