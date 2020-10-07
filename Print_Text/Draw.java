package zadanie_15;

import javax.swing.*;
import java.awt.*;

public class Draw{
        public static void main(String[] args)
        {
                new Draw();
        }
        public Draw(){
                SwingUtilities.invokeLater(() -> createGUI());
        }

        protected void createGUI() {

                JFrame jf = new JFrame ();
                jf.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
                String r =JOptionPane.showInputDialog("Podaj tekst:");
                JTextArea textArea = new JTextArea (r, 10, 20 );
                textArea.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 14));
                textArea.setForeground (Color.blue );
                textArea.setBackground (Color.green);
                jf.add ( textArea );
                jf.setTitle ( "Print Text" );
                jf.setSize(400, 400);
                jf.setLocation ( 50, 50 );
                jf.pack ();
                jf.setVisible ( true );

        }



}