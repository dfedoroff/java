package Classes;

import Classes.AbstractTypes.BasicCharacter;
import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Squad;

public class Farmer extends BasicCharacter {

    public Farmer(int line, int column, Squad allies, Squad enemies) {
        super(new Coordinates(line, column), 'F', 1, 1, new int[]{1, 1}, 1, 3, allies, enemies);
    }

    @Override
    public void step() {
        if (this.health != 0) status = "готов";
    }
}
