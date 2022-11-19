import java.util.Arrays;
import java.util.Random;

public class ArrayManip {

	public static int[] createArray(int size) {

		int[] arr = new int[size];
		int len = arr.length;
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			arr[i] = rand.nextInt(0, 2);
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void replaceElem(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] == 1) {
				arr[i] = 0;
			} else {
				arr[i] = 1;
			}
		}
	}
}
