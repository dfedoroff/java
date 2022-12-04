package Classes;

public class Spearman extends BasicCharacter {

    public Spearman(String squad, int x, int y) {
        super("Spearman", 4, 5, 0, new int []{1, 3}, 10, 4, false, false, squad);
        super.position = new Coordinates(x, y);
    }
}
