package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Shooters;
import Classes.AbstractTypes.Squad;

public class Sniper extends Shooters {

    public Sniper(int amount, int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'S', 4, 5, new int[]{1, 3}, 10, 4, allies, enemies, amount);
        this.shots = 16;
    }
}
