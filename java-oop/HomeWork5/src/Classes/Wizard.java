package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Healers;
import Classes.AbstractTypes.Squad;

public class Wizard extends Healers {
    public Wizard(int line, int column, Squad allies, Squad enemies) {
        super(new Coordinates(line, column), 'W', 17, 12, new int[]{-2, -2}, 30, 9, allies, enemies);
    }
}
