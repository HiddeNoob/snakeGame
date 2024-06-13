package main.resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SnakeAlgorithm implements KeyListener {


    Snake snake;

    public SnakeAlgorithm(Snake snake){
        this.snake = snake;

    }
    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("im snake algortihm");


        if (e.getKeyChar() == 's' || e.getKeyCode() == 40) { // 40 means down arrow, others are same for this
            if (snake.getDirection() != Snake.Direction.UP) {
                snake.setDirection(Snake.Direction.DOWN);
            }
        } else if (e.getKeyChar() == 'd' || e.getKeyCode() == 39) {
            if (snake.getDirection() != Snake.Direction.LEFT) {
                snake.setDirection(Snake.Direction.RIGHT);
            }
        } else if (e.getKeyChar() == 'w' || e.getKeyCode() == 38) {
            if (snake.getDirection() != Snake.Direction.DOWN) {
                snake.setDirection(Snake.Direction.UP);
            }
        } else if (e.getKeyChar() == 'a' || e.getKeyCode() == 37) {
            if (snake.getDirection() != Snake.Direction.RIGHT) {
                snake.setDirection(Snake.Direction.LEFT);
            }
        }
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
        Point snakeHead = snake.getSnakeTail().peek();

        for(Point snakePiece : snake.getSnakeTail()){

            if(snakePiece.x == snakeHead.x && snakePiece.y == snakeHead.y && snakeHead != snakePiece){
                return true;
            }

        }
        return false;
    }

    public void eatFoodIfAvailable(){
        for(Food food: Food.foods){
            if(snake.getSnakeTail().peek().x == food.x && snake.getSnakeTail().peek().y == food.y){
                snake.eatFood(food);
                Food.foods.remove(food);
                break;
            }
        }
    }

}