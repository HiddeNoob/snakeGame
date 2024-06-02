import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class MainPanel extends JFrame
{

    int rows = 50;
    int cols = 50;
    Canvas canvas = new Canvas(rows,cols);
    Snake snake = new Snake(20,20,20,canvas);
    MainPanel(){
        JPanel panel = new JPanel();

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);

        addKeyListener(new SnakeAlgorithm(snake,canvas));

        setVisible(true);
    }

}


