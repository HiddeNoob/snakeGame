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


    public Snake(int x, int y, int speed, int startLength, Canvas canvas) {
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

    public void eatFood(int foodSize){
        for(int i = 0; i < foodSize; i++){
            snakeTail.addFirst(new Point(snakeTail.firstElement().x , snakeTail.firstElement().y));
        }
    }






}

