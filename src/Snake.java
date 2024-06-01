import java.awt.*;
import java.util.Stack;

public class Snake {
    private int speed;
    private Stack<Point> snakeTail = new Stack<Point>();

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

}

