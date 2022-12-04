package Classes;

public class Archer extends BasicCharacter {

    public Archer(String squad, int x, int y) {
        super("Archer", 6, 3, 16, new int []{2, 3}, 10, 4, false, false, squad);
        super.position = new Coordinates(x, y);
    }
}
