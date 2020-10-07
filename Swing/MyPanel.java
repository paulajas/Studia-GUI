package zadanie_swing;

import javax.swing.*;
import java.awt.*;

class MyPanel
        extends JPanel {

    int r;
    // konstruktor
    MyPanel()
    {

        while (r > 200 || r < 1)
            r = Integer.parseInt(JOptionPane.showInputDialog("Podaj promien loga mniejszy niż 200:"));
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension (400,400));
    }

    public void paintComponent(Graphics g)
    {
                                                // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);
                                             // pobranie aktualnych rozmiarĂłw
        int height = getHeight();
        int width = getWidth();
                                                // TU RYSUJEMY!
        g.setColor(Color.red);
        g.fillOval ( width/2-r,height/2-r,2*r,2*r );
        g.setColor(Color.white);
        g.fillArc ( (int)( width/2-r*0.9),(int)(height/2-r*0.9),2*r-(2*r)/10,2*r-(2*r)/10 ,0,180 );


    }
}