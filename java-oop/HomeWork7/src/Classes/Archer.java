package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Shooters;
import Classes.AbstractTypes.Squad;

public class Archer extends Shooters {

    public Archer(int amount, int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'A', 6, 3, new int[]{2, 3}, 10, 4, allies, enemies, amount);
        this.shots = 16;
    }
}
