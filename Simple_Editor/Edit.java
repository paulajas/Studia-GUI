package ProstyEdytor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Edit extends Menu {
    private JMenu edit;

    public Edit ( JFrame jf, JTextArea jtext ) {
        super ( jf, jtext );
        edit = createJMenu ( "Edit" );

        JMenu adresy = createJMenu ( "Adresy" );
        JMenuItem praca = createSM ( "Praca", "shift P", adresy, (ActionEvent e) -> jtext.append ( "ul. Times Square 100 New York 0000\n" ) );
        JMenuItem dom = createSM ( "Dom", "shift D", adresy, (ActionEvent e) -> jtext.append ( "ul. Parapetów 1 Klamki 10-520\n" ) );
        JMenuItem szkola = createSM ( "Szkola", "shift S", adresy, (ActionEvent e) -> jtext.append ( "ul. PJATK 1 Warszawa 01-005\n" ) );
        edit.add ( adresy );
    }

    public JMenu getEdit () {
        return edit;
    }
}