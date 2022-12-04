package Classes;

public class Outlaw extends BasicCharacter {

    public Outlaw(String squad, int x, int y) {
        super("Outlaw", 8, 3, 0, new int []{2, 4}, 10, 6, false, false, squad);
        super.position = new Coordinates(x, y);
    }
}
