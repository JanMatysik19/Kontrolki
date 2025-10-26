import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Body extends JPanel {
    private final Image bgImg;

    public static final int WINDOW_RADIUS = 25;
    private static final Color WINDOW_BORDER_COLOR = new Color(59, 61, 69);


    public Body() {
        bgImg = new ImageIcon("./res/bg.jpg").getImage();

        setLayout(new BorderLayout());
        setOpaque(false);
    }



    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int pnlWidth = getWidth(),                      pnlHeight = getHeight();
        int imgWidth = bgImg.getWidth(this),    imgHeight = bgImg.getHeight(this);

        double scaleX = (double) pnlWidth / imgWidth,   scaleY = (double) pnlHeight / imgHeight;
        double scale = Math.max(scaleX, scaleY);

        int w = (int) (imgWidth * scale),   h = (int) (imgHeight * scale);
        int x = (pnlWidth - w) / 2,         y = (pnlHeight - h) / 2;

        g2.setClip(new RoundRectangle2D.Float(0, 0, pnlWidth, pnlHeight, WINDOW_RADIUS, WINDOW_RADIUS));
        g2.drawImage(bgImg, x, y, w, h, this);

        g2.setColor(new Color(0, 0, 0, (int)(255 * 0.5)));
        g2.fillRect(0, 0, pnlWidth, pnlHeight);

        g2.setColor(WINDOW_BORDER_COLOR);
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(0, 0, pnlWidth - 1, pnlHeight - 1, WINDOW_RADIUS, WINDOW_RADIUS);

        g2.dispose();
    }


    @Override
    protected void paintChildren(Graphics g) {
        var g2 = (Graphics2D) g.create();

        g2.setClip(new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, WINDOW_RADIUS, WINDOW_RADIUS));
        super.paintChildren(g2);

        g2.dispose();
    }
}
