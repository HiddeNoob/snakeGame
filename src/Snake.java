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


    Snake(int x, int y, int speed,int startLength ,Canvas canvas) {
        for(int i = 0; i < startLength; i++){
            snakeTail.push(new Point(x - i , y));
        }
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

    public void updateLocationForOutOfBounds(int canvasXLength, int canvasYLength) {

        for(Point snakePiece : snakeTail){
            if(snakePiece.x >= canvasXLength){
                snakePiece.x = 0;
            }else if(snakePiece.x < 0){
                snakePiece.x = canvasXLength - 1;
            }
            else if(snakePiece.y >= canvasYLength){
                snakePiece.y = 0;
            }else if(snakePiece.y < 0){
                snakePiece.y = canvasYLength - 1;
            }
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
                if (snake.getDirection() != Snake.Direction.UP) {
                    snake.setDirection(Snake.Direction.DOWN);
                }
                break;
            case 'd':
                if (snake.getDirection() != Snake.Direction.LEFT) {
                    snake.setDirection(Snake.Direction.RIGHT);
                }
                break;
            case 'w':
                if (snake.getDirection() != Snake.Direction.DOWN) {
                    snake.setDirection(Snake.Direction.UP);
                }
                break;
            case 'a':
                if (snake.getDirection() != Snake.Direction.RIGHT) {
                    snake.setDirection(Snake.Direction.LEFT);
                }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

