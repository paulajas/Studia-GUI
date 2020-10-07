package ProstyEdytor;
import javax.swing.*;

public class Options extends Menu {
    private JMenu options;
    private JMenu foregroundSM;
    private JMenu backgroundSM;
    private JMenu fontSizeSM;

    protected JLabel foregroundStat;
    private JLabel backgroundStat;
    private JLabel sizeStat;

    public Options (JFrame jf, JTextArea jtext){
//, JLabel foregroundStat, JLabel backgroundStat, JLabel sizeStat){
        super(jf, jtext);
        options = createJMenu("Options");
        this.foregroundStat = foregroundStat;
        this.backgroundStat = backgroundStat;
        this.sizeStat = sizeStat;

        foregroundSM = createJMenu ("Foreground");
        options.add(foregroundSM);
        backgroundSM = createJMenu("Background");
        options.add(backgroundSM);
        fontSizeSM = createJMenu("Font size");
        options.add(fontSizeSM);

        String[] colors = new String[]{
                "Green", "Orange", "Red", "Black", "White", "Yellow", "Blue"};

        for (String color : colors){
            createForegroundSM ( color, foregroundSM );
        }
        for (String color : colors){
            createBackgroundSM ( color, backgroundSM );
        }

        for(int i = 8; i < 26; i += 2) {
            createSizeSM ( i, fontSizeSM );
        }
    }

    public JMenu getOptions() {
        return options;
    }

}