package zadanie_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
public class Gui {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = frame.getFont();
                String currentTitle = frame.getTitle().trim();
                FontMetrics fm = frame.getFontMetrics(font);
                int frameWidth = frame.getWidth();
                int titleWidth = fm.stringWidth(currentTitle);
                int spaceWidth = fm.stringWidth(" ");
                int centerPos = (frameWidth / 2) - (titleWidth / 2);
                int spaceCount = centerPos / spaceWidth;
                String pad = "";
                pad = String.format("%" + (spaceCount - 14) + "s", pad);
                frame.setTitle(pad +
                        currentTitle);
            }

        });

        frame.setTitle(LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear());
        JScrollPane scrollPane = new JScrollPane();

        JList<String> list = new JList<>(new MyListModel ());
        list.setSelectedIndex(LocalDate.now().getDayOfMonth()-1 );
        scrollPane.setViewportView(list);

        scrollPane.setPreferredSize(new Dimension(300, 400));
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
