import javax.swing.*;
import java.awt.*;



public class Canvas extends JPanel{


    private final JPanel[][] canvasMatrix;




    public Canvas(int rows, int cols){


        canvasMatrix = new JPanel[rows][cols];
        setLayout(new GridLayout(rows,cols));
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                canvasMatrix[i][j] = new JPanel();
                canvasMatrix[i][j].setBackground(Color.white);
                canvasMatrix[i][j].setBorder(BorderFactory.createLineBorder(Color.black));

                add(canvasMatrix[i][j]);
            }
        }

    }

    public JPanel getPixel(int row, int col) {
        return canvasMatrix[row][col];
    }

    public void setPixelColor(int row, int col,Color c) {
        canvasMatrix[row][col].setBackground(c);
    }
}