package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Squad;
import Classes.AbstractTypes.Warriors;

public class Outlaw extends Warriors {
    public Outlaw(int line, int column, Squad allies, Squad enemies) {
        super(new Coordinates(line, column), 'O', 8, 3, new int[]{2, 4}, 10, 6, allies, enemies);
    }
}
