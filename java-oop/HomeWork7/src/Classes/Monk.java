package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Healers;
import Classes.AbstractTypes.Squad;

public class Monk extends Healers {
    public Monk(int amount, int line, int column, Squad allies, Squad enemies) {
        super(new Coordinates(line, column), 'M', 12, 7, new int[]{-5, -5}, 30, 5, allies, enemies, amount);
    }
}
