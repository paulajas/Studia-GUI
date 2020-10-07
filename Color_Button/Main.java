package zadanie_18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        final int[] s = {0};

        Color[] colors = new Color[]{
            Color.BLUE,
            Color.RED,
            Color.GRAY};

        JFrame jf = new JFrame ();
        jf.setLayout ( new FlowLayout() );

        Button b = new Button("Zamiana koloru");
        b.addMouseListener ( new MouseAdapter () {
                                 @Override
                                 public void mouseClicked(MouseEvent e) {
                                     b.setBackground ( colors[s[0]] );
                                     if (s[0] < colors.length-1)
                                         s[0]++;
                                     else
                                         s[0]=0;
                                 }
                             });

        jf.add(b);
        jf.setTitle ( "Ułożenie przycisków" );
        jf.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        jf.setLocation ( 50, 50 );
        jf.setResizable ( true );
        jf.pack ();
        jf.setVisible ( true );
        jf.setSize ( 400, 400 );
    }
}
