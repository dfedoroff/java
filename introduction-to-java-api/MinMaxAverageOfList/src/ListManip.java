import java.util.ArrayList;
import java.util.Random;

public class ListManip {

	public static void fillListRandomNums(ArrayList<Integer> lst, int size, int range) {

		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			lst.add(rand.nextInt(range));
		}
	}

	public static void findMinMaxElem(ArrayList<Integer> lst) {

		int min = lst.get(0);
		int max = min;
		int len = lst.size();

		for (int i = 0; i < len; i++) {
			if (max < lst.get(i)) {
				max = lst.get(i);
			} else if (min > lst.get(i)) {
				min = lst.get(i);
			}
		}
		System.out.println("Минимальное число списка: " + min);
		System.out.println("Максимальное число списка: " + max);
	}
}
