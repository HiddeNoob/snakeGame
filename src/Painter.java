import java.awt.*;

public class Painter {
    static public void paint(Snake snake,Canvas canvas) {


        for(int i = 0 ; i < snake.getSnakeTail().size() ; i++){
            canvas.setPixelColor(snake.getSnakeTail().get(i).x, snake.getSnakeTail().get(i).y, Color.BLACK);
        }
    }
}
