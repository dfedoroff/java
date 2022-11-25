import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		int size = 10;
		int range = 10;

		ListManip.fillListRandomNums(list, size, range);
		ListManip.removeEvenNums(list);
	}
}
