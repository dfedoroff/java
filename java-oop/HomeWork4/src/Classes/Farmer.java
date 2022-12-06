package Classes;

public class Farmer extends BasicCharacter {

    public Farmer(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'F', 1, 1, new int[]{1, 1}, 1, 3, allies, enemies);
    }

    @Override
    public void step() {
        status = "ready";
    }
}
