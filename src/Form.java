import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class Form extends JPanel {
    private final JTextField ageTxf;
    private final JCheckBox statuteChb;


    public Form() {
        Font montserratBold = null,     robotoPlain = null,     robotoSmall = null;
        try {
            montserratBold = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Montserrat-SemiBold.ttf")).deriveFont(Font.BOLD, 24f);
            robotoPlain = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(Font.BOLD, 15f);
            robotoSmall = Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(Font.PLAIN, 12f);
        } catch (Exception _) {
            System.exit(1);
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setAlignmentX(JComponent.CENTER_ALIGNMENT);
        setPreferredSize(new Dimension(350, 500));
        setMaximumSize(new Dimension(350, 500));
        setBackground(Color.GREEN);

        var margins = BorderFactory.createEmptyBorder(0, 50, 0, 50);
        setBorder(margins);

        var formLbl = new JLabel("Kontrolki");
        formLbl.setMaximumSize(new Dimension(250, 50));
        formLbl.setPreferredSize(new Dimension(250, 50));
        formLbl.setHorizontalAlignment(JLabel.CENTER);
        formLbl.setForeground(Color.WHITE);
        formLbl.setFont(montserratBold);
        add(formLbl);

        add(Box.createRigidArea(new Dimension(0, 50)));

        var ageLbl = new JLabel("Wiek");
        ageLbl.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        ageLbl.setForeground(Color.WHITE);
        ageLbl.setFont(robotoPlain);
        ageLbl.setPreferredSize(new Dimension(250, 22));
        ageLbl.setMaximumSize(new Dimension(250, 22));
        add(ageLbl);

        add(Box.createRigidArea(new Dimension(0, 10)));

        ageTxf = new AgeTxf();
        add(ageTxf);

        add(Box.createRigidArea(new Dimension(0, 30)));

        statuteChb = new StatuteChb();
        add(statuteChb);

        add(Box.createRigidArea(new Dimension(0, 50)));

        var submitBtn = new SubmitBtn();
        submitBtn.addActionListener(this::handleSubmit);
        add(submitBtn);

        add(Box.createRigidArea(new Dimension(0, 136 + 20)));

        var authorLbl = new JLabel("©Jan Matysik 4TP 2025/2026");
        authorLbl.setHorizontalAlignment(JLabel.CENTER);
        authorLbl.setPreferredSize(new Dimension(250, 13));
        authorLbl.setMaximumSize(new Dimension(250, 13));
        authorLbl.setFont(robotoSmall);
        authorLbl.setForeground(Color.WHITE);
        add(authorLbl);
    }



    public void handleSubmit(ActionEvent e) {
        int age = -1;
        boolean isStatuteAccepted = statuteChb.isSelected();

        try {
            age = Integer.parseInt(ageTxf.getText().trim());
        } catch (NumberFormatException _) { }

        if(age < 18 || !isStatuteAccepted) {
            JOptionPane.showMessageDialog(this, "Wymagany wiek 18+ i akceptacja regulaminu!", "Rejestracja", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Rejestracja pomyślna!", "Rejestracja", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();

        g2.setClip(new RoundRectangle2D.Float(0, 0, w, h, 25, 25));
        g2.setColor(new Color(4, 6, 45));
        g2.fillRect(0, 0, w, h);

        g2.setColor(new Color(38, 37, 37));
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(0, 0, w - 1, h - 1, 25, 25);

        var headerPaint = new GradientPaint(0, 0, new Color(171, 45, 26), w, 0, new Color(182, 101, 71));

        g2.setPaint(headerPaint);
        g2.fillRect(0, 0, w, 50);

        g2.dispose();
    }
}
