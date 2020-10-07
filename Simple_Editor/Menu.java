package ProstyEdytor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;



public class Menu extends JMenu{

    protected JFrame jf;
    protected JTextArea jtext;
    protected JLabel foregroundStat;
    private JLabel backgroundStat;
    private JLabel sizeStat;
    protected JLabel fileStat;
    protected boolean isSaved = false;

    public JPanel createStatPanel(JFrame jf){

        JPanel statusPanel = new JPanel ( );
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.LINE_AXIS));
        foregroundStat = new JLabel("fg");
        backgroundStat = new JLabel(" bg");
        sizeStat = new JLabel(" size");
        fileStat = new JLabel("new");

        statusPanel.add(foregroundStat,Component.LEFT_ALIGNMENT);
        statusPanel.add(backgroundStat,Component.LEFT_ALIGNMENT);
        statusPanel.add(sizeStat,Component.LEFT_ALIGNMENT);
        statusPanel.add(Box.createHorizontalGlue());
        statusPanel.add(fileStat,Component.CENTER_ALIGNMENT);

        jtext.getDocument().addDocumentListener(new DocumentListener () {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fileStat.setText("modified");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fileStat.setText("modified");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fileStat.setText("modified");
            }
        });
        return statusPanel;
    }


    public Menu (JFrame jf, JTextArea jtext){
      this.jf = jf;
      this.jtext = jtext;

    }
    public JMenu createJMenu(String name){
        JMenu menu = new JMenu(name);
        return menu;
    }
    public JMenuItem createSM (String text, String key, JMenu menu, ActionListener action) {
        JMenuItem item = new JMenuItem(text);
        item.setAccelerator(KeyStroke.getKeyStroke("control " + key));
        item.addActionListener ( action );
        menu.add(item);
        return item;
    }

    public JMenuItem createSizeSM( int size, JMenu menu){
        JMenuItem font = new JMenuItem((size) + " pts");
        font.setFont(new Font ("Dialog", Font.PLAIN, size));
        font.addActionListener((ActionEvent e) -> {
            jtext.setFont(new Font("Dialog", Font.PLAIN, size));
            sizeStat.setText (Integer.toString(size));
            sizeStat.setIconTextGap(30);
        });
        menu.add(font);
        return font;
    }

    void createForegroundSM(String nameColor, JMenu menu) {
        Color color = getColor(nameColor);
        ColorIcon icon = new ColorIcon(color);
        JMenuItem item = new JRadioButtonMenuItem("<html><p style='margin-left:10'>" + nameColor + "</p></html>", icon);
        item.setPreferredSize(new Dimension(100, item.getPreferredSize().height));
        item.setForeground(color);
        menu.add(item);
        item.addActionListener((ActionEvent e) -> {
            jtext.setForeground(color);
            foregroundStat.setIcon(icon);
            foregroundStat.setIconTextGap(30);
        });

    }

    void createBackgroundSM(String nameColor, JMenu menu) {
        Color color = getColor(nameColor);
        ColorIcon icon = new ColorIcon(color);
        JMenuItem item = new JRadioButtonMenuItem("<html><p style='margin-left:10'>" + nameColor + "</p></html>", icon);
        item.setPreferredSize(new Dimension(100, item.getPreferredSize().height));
        item.setForeground(color);
        menu.add(item);
        item.addActionListener((ActionEvent e) -> {
            jtext.setBackground (color);
            backgroundStat.setIcon(icon);
            backgroundStat.setIconTextGap(30);
        });

    }

    Color getColor(String setColor) {
        Field field;
        Color color;
        try {
            field = Color.class.getField(setColor.toLowerCase());
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = Color.black;
        }
        return color;
    }

    public JFrame getFrame() {
        return jf;
    }
}
