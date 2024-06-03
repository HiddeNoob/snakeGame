package main.resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class Snake {




    public enum Direction{
        LEFT, RIGHT, UP, DOWN
    }

    private int speed;
    private Stack<Point> snakeTail = new Stack<Point>();
    private Direction direction = Direction.RIGHT;


    public Snake(int x, int y, int speed, int startLength) {
        for(int i = 0; i < startLength; i++){
            snakeTail.push(new Point(x + i , y));
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

    public void eatFood(Food food){
        food.isEated = true;
        for(int i = 0; i < food.score; i++){
            snakeTail.addFirst(new Point(snakeTail.firstElement().x , snakeTail.firstElement().y));
        }


    }






}

