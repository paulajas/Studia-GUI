package zadanie_17;

import javax.swing.*;
import java.awt.*;

public class Swing {

    public static void main(String[] args){
        LayoutManager[] list = {
                    new BorderLayout (  ),
                    new FlowLayout(),
                    new FlowLayout(FlowLayout.LEFT),
                    new FlowLayout(FlowLayout.RIGHT),
                    new GridLayout(1,0),
                    new GridLayout(0,1),
                    new GridLayout(3,2)
    };
        String option = JOptionPane.showInputDialog("Wybierz uklad przysickow A-G").toUpperCase ();

        JFrame jf = new JFrame();
        Container contentPane = jf.getContentPane();
        contentPane.setLayout ( list[option.charAt(0)-65] );

        jf.setTitle("Ułożenie przycisków");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(50,50);
        jf.setResizable(false);
        jf.pack( );
        jf.setVisible(true);
        jf.setSize(400,300);

        contentPane.add( new JButton("Przycisk 1"),BorderLayout.NORTH);
        contentPane.add(new JButton("P 2"),BorderLayout.WEST);
        contentPane.add(new JButton("Większy przycisk numer 3"),BorderLayout.CENTER);
        contentPane.add(new JButton("Przycisk 4"),BorderLayout.EAST);
        contentPane.add(new JButton("P5"), BorderLayout.SOUTH);
    }

}
