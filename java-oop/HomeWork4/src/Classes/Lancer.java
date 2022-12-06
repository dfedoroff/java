package Classes;

public class Lancer extends BasicCharacter {

    public Lancer(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column),'L',4, 5,  new int[]{1,3}, 10, 4, allies, enemies);
    }

    @Override
    public void step() {

    }
}
