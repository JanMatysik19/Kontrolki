import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TitleBar extends JPanel {
    private CloseBtn closeBtn;
    private MinimizeBtn minimizeBtn;
    private JPanel eastButtons;

    private final JFrame appFrame;
    private final Point clickPoint = new Point();

    public static final Color TITLE_BAR_BG_COLOR = new Color(43, 46, 84, (int)(255 * 0.2));


    public TitleBar(JFrame appFrame) {
        this.appFrame = appFrame;

        setOpaque(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(-1, 25));

        addMouseListener(new BarClickHandler());
        addMouseMotionListener(new BarMouseMoveHandler());

        eastButtons = new JPanel();
        eastButtons.setLayout(new BoxLayout(eastButtons, BoxLayout.X_AXIS));
        eastButtons.setOpaque(false);

        minimizeBtn = new MinimizeBtn(appFrame);
        eastButtons.add(minimizeBtn);

        closeBtn = new CloseBtn();
        eastButtons.add(closeBtn);

        add(eastButtons, BorderLayout.EAST);
    }


    private class BarClickHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            clickPoint.setLocation(e.getPoint());
        }
    }

    private class BarMouseMoveHandler extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            var currScreen = e.getLocationOnScreen();

            appFrame.setLocation((int) currScreen.getX() - clickPoint.x, (int) currScreen.getY() - clickPoint.y);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(TITLE_BAR_BG_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.dispose();
    }
}
