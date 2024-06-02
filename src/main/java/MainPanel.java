package main.java;

import main.resources.*;
import main.resources.Canvas;
import main.resources.Painter;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class MainPanel extends JFrame
{

    int rows = 20;
    int cols = 20;
    Canvas canvas = new Canvas(rows,cols);

    Snake snake = new Snake(rows/2,cols/2,10,2,canvas);
    SnakeAlgorithm snakeAlgorithm = new SnakeAlgorithm(snake);

    MainPanel(){
        JPanel panel = new JPanel();

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);

        addKeyListener(new SnakeAlgorithm(snake));

        setVisible(true);




        new Thread(new Runnable() {


            @Override
            public void run() {

                new Thread(new Runnable() {


                    @Override
                    public void run() {
                        int counter = 0;

                        while (true){
                            try {
                                Thread.sleep(Duration.ofMillis(1));
                                counter++;
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if(counter >= 1000){
                                counter = 0;
                                int time = (int) (Math.random()*9000) + 1000; // min 1 sec max 9 sec
                                int score = 3000/time + 1;
                                Food createdFood = new Food((int) (Math.random() * cols), (int) (Math.random() * rows),time , score);
                                System.out.println(createdFood);
                                new  Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        int counter = createdFood.delay;
                                        while (true){

                                            try {
                                                Thread.sleep(Duration.ofMillis(1));
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }

                                            if(counter <= 1){
                                                Food.deleteFood(createdFood);
                                                canvas.setPixelColor(createdFood.x, createdFood.y, Color.WHITE);
                                                break;
                                            }
                                            Color color = new Color((float) 1,(float) 0.5 + ((float) 0.5 - (float) counter-- / createdFood.delay / 2), (float) 1 - ((float) (counter--) /createdFood.delay));
                                            canvas.setPixelColor(createdFood.x, createdFood.y,color);
                                        }
                                    }
                                }).start();
                            }


                        }

                    }
                }).start();

                while (true){
                    try {
                        Thread.sleep( 1000 / snake.getSpeed());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Point snakeTail = snakeAlgorithm.updateSnakeLocation();
                    canvas.setPixelColor(snakeTail.x, snakeTail.y, Color.WHITE);

                    snakeAlgorithm.eatFoodIfAvailable();
                    snakeAlgorithm.updateLocationForOutOfBounds(cols,rows);
                    
                    if(snakeAlgorithm.checkSnakeTouchSelf())
                        System.exit(1);



                    Painter.paint(snake,canvas);






                }
            }
        }).start();



    }

}

/*



 */


