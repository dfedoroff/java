public class ArrayManip {

	static void fillDiagonal(int[][] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			arr[i][i] = 1;
			arr[len - i - 1][i] = 1;
		}
	}
}
