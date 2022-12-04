package Classes;

public class Wizard extends BasicCharacter {

    public Wizard(String squad, int x, int y) {
        super("Wizard", 17, 12, 0, new int []{-5, -5}, 30, 9, false, true, squad);
        super.position = new Coordinates(x, y);
    }
}
