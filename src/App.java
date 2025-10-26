import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private Body content;
    private Main main;
    private TitleBar titleBar;


    public App() {
        content = new Body();
        setContentPane(content);


        titleBar = new TitleBar(this);
        content.add(titleBar, BorderLayout.NORTH);

        main = new Main();
        content.add(main, BorderLayout.CENTER);


        setTitle("Kontrolki");
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setBounds(200, 200, 500, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    public static void main(String[] args) {
        new App();
    }
}
