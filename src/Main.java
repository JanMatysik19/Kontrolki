import javax.swing.*;

public class Main extends JPanel {
    public Main() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        add(Box.createVerticalGlue());

        var form = new Form();
        add(form);

        add(Box.createVerticalGlue());
    }
}
