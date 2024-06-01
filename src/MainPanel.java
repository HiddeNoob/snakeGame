import javax.swing.*;

public class MainPanel extends JFrame
{

    Canvas canvas = new Canvas(50,50);

    MainPanel(){
        JPanel panel = new JPanel();

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);


        setVisible(true);
    }

}
