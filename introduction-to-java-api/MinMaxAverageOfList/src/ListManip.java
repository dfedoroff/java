import java.util.ArrayList;
import java.util.Random;

public class ListManip {

	public static void fillListRandomNums(ArrayList<Integer> lst, int size, int range) {

		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			lst.add(rand.nextInt(range));
		}
	}
}
