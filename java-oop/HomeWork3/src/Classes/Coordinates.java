package Classes;

public class Coordinates {

	public int x;
	public int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqual(Coordinates position) {
		return position.y == y && position.x == x;
	}
}
