import java.util.Arrays;
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

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void findMinMaxElem(int[] arr) {

		int min = arr[0];
		int max = arr[0];

		for (int j : arr) {
			if (j < min) {
				min = j;
			} else if (j > max) {
				max = j;
			}
		}
		System.out.println("Минимальный элемент массива: " + min);
		System.out.println("Максимальный элемент массива: " + max);
	}
}
