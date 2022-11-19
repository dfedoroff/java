import java.util.Arrays;

public class ArrayManip {

	public static int[] createArray(int len, int initialValue) {

		int[] arr = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = initialValue;
		}
		return arr;
	}
}
