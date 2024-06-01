import javax.swing.*;
import java.awt.*;



public class Canvas extends JFrame{

    final private int rows = 50;
    final private int cols = 50;
    final private int windowWidth = 800, windowHeight = 800;

    public JPanel[][] canvasMatrix = new JPanel[rows][cols];

    Canvas(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake Game");
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(rows,cols));

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                canvasMatrix[i][j] = new JPanel();
                canvasMatrix[i][j].setBackground(Color.white);
                canvasMatrix[i][j].setBorder(BorderFactory.createLineBorder(Color.black));

                add(canvasMatrix[i][j]);
            }
        }


        setVisible(true);
    }
}