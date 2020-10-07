package ProstyEdytor;

import javax.swing.*;
import java.awt.*;


public class ProstyEdytor {

    boolean fileLoaded = false;
    String currentFileName = "Prosty edytor - bez tytulu";

    public static void main(String[] args){
        new ProstyEdytor ();
    }

    public ProstyEdytor()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI() {

        JFileChooser fileChooser;
        JTextArea textArea = new JTextArea();
        //JPanel paneText = new JPanel (  );
        //paneText.add(textArea);
        JFrame jf = new JFrame (  );
        jf.add(textArea);

        JMenuBar mb = new JMenuBar();
        //File file = new File(jf,textarea,fileStatus);
        Edit edit = new Edit(jf,textArea);
        Options options = new Options(jf,textArea);
        //, foregroundStat, backgroundStat, sizeStat);
        File file = new File(jf,textArea);
        mb.add(file.getFile());
        mb.add(edit.getEdit());
        mb.add(options.getOptions ());
        jf.setJMenuBar(mb);


        JScrollPane jscrollH = new JScrollPane ( textArea);
        jscrollH.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jf.add(jscrollH);
        JScrollPane jscrollW = new JScrollPane ( textArea ) ;
        jscrollW.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jf.add(jscrollW);


        JPanel statPanel = options.createStatPanel ( jf );
        jf.add(statPanel, BorderLayout.SOUTH);

        jf.setTitle ( currentFileName );
        jf.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        jf.setLocation ( 50, 50 );
        jf.setResizable ( false );
        jf.setPreferredSize (new Dimension (  800, 400 ));
        jf.pack ();
        jf.setVisible ( true );
    }
}
