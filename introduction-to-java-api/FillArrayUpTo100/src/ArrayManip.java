import java.util.Arrays;

public class ArrayManip {

	public static int[] createArray(int len) {

		int[] arr = new int[len];

		for (int i = 1; i <= len; ++i) {
			arr[i - 1] = i;
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
