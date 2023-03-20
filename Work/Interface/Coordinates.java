package Interface;

import Abstract.BaseHero;

public class Coordinates {
    
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getDistance(BaseHero unit) {
        return (float) Math.sqrt(Math.pow(x - unit.position.x, 2) + Math.pow(y - unit.position.y, 2));
    }
}
