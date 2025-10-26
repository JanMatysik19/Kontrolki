import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class AgeTxf extends JTextField {
    private boolean isSelected = false;


    public AgeTxf() {
        Font robotoPlain = null;
        try {
            robotoPlain = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(Font.BOLD, 12f);
        } catch (Exception _) {
            System.exit(1);
        }

        setAlignmentX(JComponent.LEFT_ALIGNMENT);

        setPreferredSize(new Dimension(250, 38));
        setMaximumSize(new Dimension(250, 38));
        setMinimumSize(new Dimension(250, 38));

        setForeground(Color.WHITE);
        setFont(robotoPlain);

        setOpaque(false);

        var padBrd = BorderFactory.createEmptyBorder(0, 10, 0, 10);
        setBorder(padBrd);

        addFocusListener(new FocusHandler());
    }



    private class FocusHandler extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            super.focusGained(e);
            isSelected = true;
            repaint();
        }

        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            isSelected = false;
            repaint();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(),     h = getHeight();

        g2.setClip(new RoundRectangle2D.Float(0, 0, w, h, 20, 20));
        g2.setColor(new Color(25, 28, 80));
        g2.fillRect(0, 0, w, h);

        super.paintComponent(g);

        if(isSelected) {
            var paint = new GradientPaint(0, 0, new Color(243, 63, 35), w, 0, new Color(255, 138, 95));
            g2.setPaint(paint);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(0, 0, w - 1, h - 1, 20, 20);
        }

        g2.dispose();
    }
}
