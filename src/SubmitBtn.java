import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class SubmitBtn extends JButton {
    public SubmitBtn() {
        Font robotoPlain = null;
        try {
            robotoPlain = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(Font.BOLD, 15f);
        } catch (Exception _) {
            System.exit(1);
        }

        setText("Zatwierź");
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(robotoPlain);

        setBackground(new Color(0, 0, 0, 0));

        setPreferredSize(new Dimension(250, 40));
        setMaximumSize(new Dimension(250, 40));
        setOpaque(false);

        setBorderPainted(false);
        setFocusPainted(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(),     h = getHeight();

        var paint = new GradientPaint(0, 0, new Color(243, 63, 35), w, 0, new Color(255, 138, 95));
        g2.setPaint(paint);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, 20, 20));

        super.paintComponent(g);

        g2.dispose();
    }
}
