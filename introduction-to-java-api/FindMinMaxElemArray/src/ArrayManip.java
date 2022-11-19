import java.util.Random;

public class ArrayManip {

	public static int[] createArray(int size) {

		int[] arr = new int[size];
		int len = arr.length;
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			arr[i] = rand.nextInt(100 - (-100)) + (-100);
		}
		return arr;
	}
}
