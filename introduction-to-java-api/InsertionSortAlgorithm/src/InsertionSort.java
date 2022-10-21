public class InsertionSort {
	public static void sort(int[] arr) {

		int len = arr.length;

		for (int i = 1; i < len; i++) {
			int curNum = arr[i];
			int curIndex = i - 1;

			while (curIndex >= 0 && arr[curIndex] > curNum) {
				arr[curIndex + 1] = arr[curIndex];
				curIndex--;
			}
			arr[curIndex + 1] = curNum;
		}
	}
}
