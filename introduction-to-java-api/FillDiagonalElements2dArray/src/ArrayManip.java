public class ArrayManip {

	static void fillDiagonal(int[][] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			arr[i][i] = 1;
			arr[len - i - 1][i] = 1;
		}
	}

	public static void printArray(int[][] arr) {

		int lenRow = arr.length;
		int lenCol = arr[0].length;

		for (int i = 0; i < lenRow; i++) {
			for (int j = 0; j < lenCol; j++) {
				System.out.print(arr[i][j] + " ");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
