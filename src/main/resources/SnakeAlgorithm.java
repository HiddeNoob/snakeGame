package main.resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SnakeAlgorithm implements KeyListener {


    Snake snake;
    ArrayList<Point> foods = new ArrayList<Point>();

    public SnakeAlgorithm(Snake snake){
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

    public void updateLocationForOutOfBounds(int canvasXLength, int canvasYLength) {

        for(Point snakePiece : snake.getSnakeTail()){
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

    public Point updateSnakeLocation(){
        int deltaX = 0;
        int deltaY = 0;
        if(snake.getDirection() == Snake.Direction.LEFT){
            deltaX = -1;
        }
        else if(snake.getDirection() == Snake.Direction.RIGHT){
            deltaX = 1;
        }else if(snake.getDirection() == Snake.Direction.UP){
            deltaY = -1;
        }else if(snake.getDirection() == Snake.Direction.DOWN){
            deltaY = 1;
        }

        snake.getSnakeTail().push(new Point(snake.getSnakeTail().peek().x + deltaX, snake.getSnakeTail().peek().y + deltaY));
        return snake.getSnakeTail().removeFirst(); // remove the tail and add to head

    }

    public boolean checkSnakeTouchSelf(){
        for(Point snakePiece : snake.getSnakeTail()){

            if(snakePiece.x == snake.getSnakeTail().peek().x && snakePiece.y == snake.getSnakeTail().peek().y && snake.getSnakeTail().peek() != snakePiece){
                    return true;

            }
        }
        return false;
    }

}