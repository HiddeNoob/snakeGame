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
    Snake snake = new Snake(20,20,10,5,canvas);

    MainPanel(){
        JPanel panel = new JPanel();

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);

        addKeyListener(new SnakeAlgorithm(snake,canvas));

        setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep( 1000 / snake.getSpeed());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    snake.updateSnakeLocation();
                    snake.updateLocationForOutOfBounds(cols,rows);
                    canvas.resetCanvas();
                    Painter.paint(snake,canvas);

                }
            }
        }).start();
    }

}


