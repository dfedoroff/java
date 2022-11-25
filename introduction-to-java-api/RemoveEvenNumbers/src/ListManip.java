import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ListManip {

	public static void fillListRandomNums(ArrayList<Integer> lst, int size, int range) {

		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			lst.add(rand.nextInt(range));
		}
	}

	public static void removeEvenNums(ArrayList<Integer> lst) {

		Iterator<Integer> itr = lst.iterator();

		while (itr.hasNext()) {
			if (itr.next() % 2 == 0) {
				itr.remove();
			}
		}
	}
}
