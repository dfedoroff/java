package Classes;

public class Outlaw extends BasicCharacter {

    public Outlaw(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'O', 8, 3, new int[]{2, 4}, 10, 6, allies, enemies);
    }

    @Override
    public void step() {

    }
}
