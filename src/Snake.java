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


    Snake(int x, int y, int speed,Canvas canvas) {
        snakeTail.push(new Point(x , y));
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

    public Stack<Point> getSnakeTail() {
        return snakeTail;
    }

    public void updateSnakeLocation(){
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
        Point tail = snakeTail.removeFirst(); // remove the tail and add to head

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

