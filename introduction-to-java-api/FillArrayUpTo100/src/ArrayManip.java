public class ArrayManip {

	public static int[] createArray(int len) {

		int[] arr = new int[len];

		for (int i = 1; i <= len; ++i) {
			arr[i - 1] = i;
		}
		return arr;
	}
}
