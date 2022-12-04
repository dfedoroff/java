package Classes;

public class Farmer extends BasicCharacter {

    public Farmer(String squad, int x, int y) {
        super("Farmer", 1, 1, 0, new int []{1,1}, 1, 3, true, false, squad);
        super.position = new Coordinates(x, y);
    }
}
