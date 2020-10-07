
package ProstyEdytor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class File extends Menu{

        JMenu file;
        String savePath;
        String parent=null;

        public File(JFrame jf, JTextArea jtext) {
            super ( jf, jtext );
            file = createJMenu ( "File" );

            JMenuItem open = createSM ( "Open", "O", file, (ActionEvent e) -> {
                JFileChooser jfc = new JFileChooser (parent);
                if (jfc.showOpenDialog ( null ) == JFileChooser.APPROVE_OPTION) {
                    java.io.File plik = jfc.getSelectedFile ();
                    savePath =  jfc.getSelectedFile ().getAbsolutePath ();
                    parent = plik.getParent ();
                    try {
                        Scanner skaner = new Scanner ( plik );
                        while (skaner.hasNext ())
                            jtext.append ( skaner.nextLine () + "\n" );
                        jf.setTitle ( "Prosty edytor - " + jfc.getSelectedFile ().getAbsolutePath () );
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog ( null, "Some problem occurs" );
                    }
                    isSaved = true;
                }
                fileStat.setText ( "saved" );
            } );

            JMenuItem save = createSM ( "Save", "S", file, (ActionEvent e) ->{
                    if (!isSaved) {
                        saving ();
                    } else {
                        FileWriter writer;
                        try {
                            writer = new FileWriter ( savePath );
                            jtext.write ( writer );
                        } catch (IOException ex) {
                            //ex.printStackTrace();
                        }
                        fileStat.setText ( "saved" );
                    }
                });

            JMenuItem saveas = createSM ( "Save As", "A", file, (ActionEvent e) -> {
                saving();
            });

            JSeparator sep = new JSeparator ();
            sep.setBackground ( Color.RED );
            sep.setForeground ( Color.RED );
            file.add ( sep );

            JMenuItem exit = createSM ( "Exit", "X", file, (ActionEvent e) ->
            {System.exit(0);
            });
        }

        public void saving() {

            JFileChooser jfc = new JFileChooser ( parent );
            if (jfc.showSaveDialog ( null ) == JFileChooser.APPROVE_OPTION) ;
            java.io.File plik = jfc.getSelectedFile ();
            parent = plik.getParent ();
            jf.setTitle ( "Prosty edytor - " + jfc.getSelectedFile ().getAbsolutePath () );
            try {
                FileWriter writer = new FileWriter ( jfc.getSelectedFile () );
                jtext.write ( writer );
                isSaved = true;
                savePath =  jfc.getSelectedFile ().getAbsolutePath ();
            } catch (IOException ex) {
                ex.printStackTrace ();
            }
            jfc.setVisible ( true );
            fileStat.setText ( "saved" );
        }

        public JMenu getFile () {
            return file;
        }

}