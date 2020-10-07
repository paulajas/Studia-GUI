package zadanie_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gui {

    String text = "";

    public static void main(String[] args){
        new Gui();
    }

    public Gui()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI() {

        String notNumber = "Number format error";
        String notEq = "Not a quadratic equation!";
        //JFrame.setDefaultLookAndFeelDecorated ( true );
        JFrame jf = new JFrame ();

        JPanel frame = new JPanel (  );

        JLabel label = new JLabel(text,SwingConstants.CENTER);
        JPanel forLabel = new JPanel (  );
        JPanel panel = new JPanel ();
        JTextField a = new JTextField ( SwingConstants.CENTER );
        JTextField b = new JTextField ( SwingConstants.CENTER );
        JTextField c = new JTextField ( SwingConstants.CENTER );

        panel.setLayout ( new GridLayout ( 1,3));

        a.setHorizontalAlignment(JTextField.CENTER);
        b.setHorizontalAlignment(JTextField.CENTER);
        c.setHorizontalAlignment(JTextField.CENTER);

        a.setToolTipText ( "Enter a" );
        b.setToolTipText ( "Enter b" );
        c.setToolTipText ( "Enter c" );

        a.setBackground ( Color.WHITE) ;
        b.setBackground ( Color.WHITE) ;
        c.setBackground ( Color.WHITE) ;
        panel.add(a, BorderLayout.NORTH);
        panel.add(b, BorderLayout.CENTER);
        panel.add(c, BorderLayout.SOUTH);

        JButton solve = new JButton ("Solve");
        solve.addActionListener ( ( ActionEvent e ) ->{
            try{
                double a1 = Double.parseDouble ( a.getText () );
                    if (a1 == 0) {
                        forLabel.setBackground ( Color.RED );
                        label.setForeground ( Color.BLACK );
                        label.setText ( "Not a quadratic equation!" );

                    } else {
                        double b1 = Double.parseDouble ( b.getText () );
                        double c1 = Double.parseDouble ( c.getText () );
                        Mathematic eq = new Mathematic ( a1, b1, c1 );
                        label.setForeground ( Color.BLUE );
                        forLabel.setBackground ( Color.WHITE );
                        label.setText ( eq.wyniki () );
                    }
                } catch (NumberFormatException exc) {
                forLabel.setBackground ( Color.RED );
                label.setForeground ( Color.BLACK );
                label.setText ( "Wrong number!" );

                }
        });
        solve.setMnemonic ( 's' );   //KeyEvent.VK_S);

        JButton clear = new JButton ("Clear");
        clear.addActionListener (( ActionEvent e) -> {
                a.setText(null);
                b.setText ( null );
                c.setText(null);
                label.setText ( null );
                label.setForeground ( Color.BLACK );
                forLabel.setBackground ( Color.WHITE);
                label.repaint ();
                jf.repaint (  );
            }
        );
        clear.setMnemonic ( KeyEvent.VK_C );


        //jf.setLayout ( new GridLayout(4,1) );
        frame.setLayout ( new GridLayout(4,1) );

        forLabel.add(label, Component.CENTER_ALIGNMENT);
        forLabel.setLayout ( new GridBagLayout () );
        //jf.add(forLabel, Component.CENTER_ALIGNMENT);
        frame.add(forLabel, Component.CENTER_ALIGNMENT);

/*
        jf.add(panel);
        jf.add(solve);
        jf.add ( clear );
*/
        frame.add(panel);
        frame.add(solve);
        frame.add ( clear );

        jf.add(frame);
        //jf.setLayout(new FlowLayout (  ));
        jf.setTitle ( "Quadratic Equation" );
        jf.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        jf.setLocation ( 50, 50 );
        jf.setResizable ( false );
        jf.setPreferredSize (new Dimension (  400, 200 ));
        jf.pack ();
        jf.setVisible ( true );
    }

}
