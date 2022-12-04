package Classes;

public class Sniper extends BasicCharacter {

    public Sniper(String squad, int x, int y) {
        super("Sniper", 12, 10, 32, new int []{8, 10}, 15, 9, false, false, squad);
        super.position = new Coordinates(x, y);
    }
}
