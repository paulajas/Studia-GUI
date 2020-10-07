package ProstyEdytor;

import javax.swing.*;
import java.awt.*;

public class ColorIcon implements Icon{
    Color color;
    int x;
    int y;

    public ColorIcon(Color color) {
        this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(18,5,10,10);
        }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}
