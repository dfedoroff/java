package Classes.AbstractTypes;

import static java.lang.Math.abs;

public class Coordinates {

    public int x;
    public int y;

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public static double getDistance(Coordinates a, Coordinates b){
        return Math.hypot(abs(b.x - a.x), abs(b.y - a.y));
    }

    public boolean isClose(Coordinates b){
        return abs(x - b.x) <= 1 && abs(y - b.y) <= 1;
    }

    public boolean isEqual(Coordinates position) {
        return position.y == y && position.x == x;
    }
}
