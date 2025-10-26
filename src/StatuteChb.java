import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class StatuteChb extends JCheckBox {

    public StatuteChb() {
        Font robotoPlain = null;
        try {
            robotoPlain = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(Font.BOLD, 12f);
        } catch (Exception _) {
            System.exit(1);
        }

        setText("Akceptuję regulamin.");
        setFont(robotoPlain);
        setForeground(Color.WHITE);

        setOpaque(false);

        setPreferredSize(new Dimension(250, 20));
        setMaximumSize(new Dimension(250, 20));
        setMinimumSize(new Dimension(250, 20));

        var icon = new CheckIcon();
        setIcon(icon);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }



    private static class CheckIcon implements Icon {
        private final int size = 20;

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            var btn = (AbstractButton) c;
            var model = btn.getModel();

            var g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(25, 28, 80));
            g2.fill(new RoundRectangle2D.Float(0, 0, size, size, 10, 10));

            if(model.isSelected()) {
                var paint = new GradientPaint(0, 0, new Color(243, 63, 35), size, 0, new Color(255, 138, 95));
                g2.setPaint(paint);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(5, size /2, size / 2, size - 5);
                g2.drawLine(size / 2, size - 5, size - 5, 5);
            }

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }
    }
}
