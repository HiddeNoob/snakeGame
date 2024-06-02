import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class Snake {


    private final Canvas canvas;

    enum Direction{
        LEFT, RIGHT, UP, DOWN
    }

    private int speed;
    private Stack<Point> snakeTail = new Stack<Point>();
    private Direction direction = Direction.RIGHT;

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000/speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                changeSnakeLocation();
                paintSnake();

            }
        }
    });

    Snake(int x, int y, int speed,Canvas canvas) {
        this.canvas = canvas;

        snakeTail.push(new Point(x , y));

        this.speed = speed;
        thread.start();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void changeSnakeLocation(){
        int deltaX = 0;
        int deltaY = 0;
        if(direction == Direction.LEFT){
            deltaX = -1;
        }
        else if(direction == Direction.RIGHT){
            deltaX = 1;
        }else if(direction == Direction.UP){
            deltaY = -1;
        }else if(direction == Direction.DOWN){
            deltaY = 1;
        }

        System.out.println(deltaX + " " + deltaY);
        snakeTail.push(new Point(snakeTail.peek().x + deltaX, snakeTail.peek().y + deltaY));
        Point tail = snakeTail.remove(0); // to remove the tail in canvas
        canvas.setPixelColor(tail.x, tail.y, Color.WHITE);

    }

    private void paintSnake(){
        for(int i = 0; i < snakeTail.size(); i++){
            System.out.println(snakeTail.get(i).x + " " + snakeTail.get(i).y);
            canvas.setPixelColor(snakeTail.get(i).x, snakeTail.get(i).y, Color.BLACK);
        }
    }
}


class SnakeAlgorithm implements KeyListener {


    Snake snake;

    SnakeAlgorithm(Snake snake,Canvas canvas){
        this.snake = snake;

    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 's':
                snake.setDirection(Snake.Direction.DOWN);
                break;
            case 'd':
                snake.setDirection(Snake.Direction.RIGHT);
                break;
            case 'w':
                snake.setDirection(Snake.Direction.UP);
                break;
            case 'a':
                snake.setDirection(Snake.Direction.LEFT);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

