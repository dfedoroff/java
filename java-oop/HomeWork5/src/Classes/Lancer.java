package Classes;

import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Squad;
import Classes.AbstractTypes.Warriors;

public class Lancer extends Warriors {
    public Lancer(int line, int column, Squad allies, Squad enemies) {
        super(new Coordinates(line, column),'L',4, 5,  new int[]{1,3}, 10, 4, allies, enemies);
    }
}
