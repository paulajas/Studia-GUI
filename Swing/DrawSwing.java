package zadanie_swing;

import javax.swing.*;

public class DrawSwing {

    public static void main(String[] args)
    {
        new DrawSwing();
    }

    public DrawSwing()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI()
    {
        // utworzenie okna
        JFrame jf = new JFrame();

        // okreĹlenie tytuĹu okna
        jf.setTitle("Rysowanie");

        // obsĹuga zamkniÄcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // okreĹlenie poĹoĹźenia okna
        jf.setLocation(50,50);

        // uniemoĹźliwienie zmiany rozmiarĂłw okna
        jf.setResizable(false);

        // utworzenie obszaru rysowania - pulpitu
        MyPanel p = new MyPanel();

        // wymiana domyĹlnego pulpitu na wĹasny
        jf.setContentPane(p);

        // upakowanie okna
        jf.pack( );

        // wyĹwietlenie okna
        jf.setVisible(true);
    }
}
