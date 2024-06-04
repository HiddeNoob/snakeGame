package main.app;

import main.resources.*;
import main.resources.Canvas;
import main.resources.Painter;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class GamePanel extends JPanel
{

    boolean gameEnded = false;
    Snake snake;
    SnakeAlgorithm snakeAlgorithm;

    GamePanel(RunGame mainFrame, Canvas canvas){


        snake = new Snake(canvas.getRows()/2, canvas.getCols() /2,10,6);
        snakeAlgorithm = new SnakeAlgorithm(snake);
        setLayout(new BorderLayout());
        add(canvas,BorderLayout.CENTER);

        mainFrame.addKeyListener(snakeAlgorithm);
        this.addKeyListener(snakeAlgorithm);

        setVisible(true);




        new Thread(new Runnable() {


            @Override
            public void run() {

                new Thread(new Runnable() {


                    @Override
                    public void run() {
                        int counter = 0;

                        while (!gameEnded){
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
                                Food createdFood = new Food((int) (Math.random() * canvas.getCols()), (int) (Math.random() * canvas.getRows()),time , score);
                                System.out.println(createdFood);
                                new  Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        int constantCounter = createdFood.delay;
                                        while (true){

                                            try {
                                                Thread.sleep(Duration.ofMillis(1));
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }

                                            if(createdFood.delay-- <= 1){
                                                Food.deleteFood(createdFood);
                                                canvas.setPixelColor(createdFood.x, createdFood.y, Color.WHITE);
                                                break;
                                            }
                                            if(createdFood.isEated){
                                                canvas.setPixelColor(createdFood.x, createdFood.y, Color.BLACK);
                                                break;
                                            }
                                            Color color = new Color((float) 1,  1- (float) createdFood.delay / constantCounter,  1 - (float) createdFood.delay / constantCounter);
                                            canvas.setPixelColor(createdFood.x, createdFood.y,color);
                                        }
                                    }
                                }).start();
                            }


                        }


                    }
                }).start();

                while (!gameEnded){
                    try {
                        Thread.sleep( 1000 / snake.getSpeed());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Point snakeTail = snakeAlgorithm.updateSnakeLocation();
                    canvas.setPixelColor(snakeTail.x, snakeTail.y, Color.WHITE);

                    snakeAlgorithm.updateLocationForOutOfBounds(canvas.getCols(), canvas.getRows());
                    snakeAlgorithm.eatFoodIfAvailable();


                    if(snakeAlgorithm.checkSnakeTouchSelf()){
                        gameEnded = true;
                        mainFrame.showGameEndPanel(snake.getSnakeTail().size());
                    }


                    Painter.paint(snake,canvas);






                }


            }
        }).start();




    }

}

/*



 */


