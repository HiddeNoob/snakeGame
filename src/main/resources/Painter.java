package main.resources;

import java.awt.*;
import java.time.Duration;

public class Painter {
    static public void paint(Snake snake,Canvas canvas) {


        for(int i = 0 ; i < snake.getSnakeTail().size() ; i++){
            canvas.setPixelColor(snake.getSnakeTail().get(i).x, snake.getSnakeTail().get(i).y, Color.BLACK);
        }
    }

    static public void paint(Food food,Canvas canvas,Color color) {
        canvas.setPixelColor(food.x, food.y, color);
    }
}


