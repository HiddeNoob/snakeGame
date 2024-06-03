package main.resources;

import java.util.ArrayList;

public class Food {
    public boolean isEated = false;
    public int x;
    public int y;
    public int delay; // delay for disappear
    public int score; // snake will grow up relatable to this score
    public Food(int x, int y, int delay, int score) {
        this.delay = delay;
        this.score = score;
        this.x = x;
        this.y = y;
        foods.add(this);
    }

    static public ArrayList<Food> foods = new ArrayList<Food>();

    static public void deleteFood(Food food) {
        foods.remove(food);
    }

    @Override
    public String toString() {
        return "Food{" +
                "x=" + x +
                ", y=" + y +
                ", delay=" + delay +
                ", score=" + score +
                '}';
    }
}
