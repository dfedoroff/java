public class HeapSort {

	private static void swap(int a, int b) {

		int temp = a;
		a = b;
		b = temp;
	}

	public static void sort(int[] arr) {

		int len = arr.length;

		for (int i = len / 2 - 1; i >= 0; i--) {
			buildHeap(arr, i, len);
		}

		for (int i = len - 1; i >= 0; i--) {
			swap(arr[0], arr[i]);
			buildHeap(arr, 0, i);
		}
	}

	public static void buildHeap(int[] arr, int i, int heapLen) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;

		if (left < heapLen && arr[left] > arr[max]) {
			max = left;
		}

		if (right < heapLen && arr[right] > arr[max]) {
			max = right;
		}

		if (max != i) {
			swap(arr[i], arr[max]);
			buildHeap(arr, heapLen, max);
		}
	}
}
