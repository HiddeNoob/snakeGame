import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class Snake {


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

    Snake(int x, int y, int speed) {
        snakeTail.push(new Point(x, y));
        this.speed = speed;
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
        int deltaX = direction == Direction.RIGHT ? 1 : -1;
        int deltaY = direction == Direction.UP ? 1 : -1;

        snakeTail.pop();
        snakeTail.push(new Point(snakeTail.peek().x + deltaX, snakeTail.peek().y + deltaY));
    }

    private void paintSnake(){

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

