import java.util.Arrays;

public class ArrayManip {
	static void multiply(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] < 6) {
				arr[i] *= 2;
			}
		}
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
