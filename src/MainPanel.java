import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JFrame
{

    int rows = 50;
    int cols = 50;
    Canvas canvas = new Canvas(rows,cols);

    MainPanel(){
        JPanel panel = new JPanel();

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);


        setVisible(true);
    }


}
