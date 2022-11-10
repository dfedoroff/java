public class QuickSort {
	static void swap(int[] arr, int low, int pivot) {

		int temp = arr[low];
		arr[low] = arr[pivot];
		arr[pivot] = temp;
	}

	static int partition(int[] arr, int low, int high) {

		int p = low, i;

		for (i = low + 1; i <= high; i++) {
			if (arr[i] < arr[low]) {
				swap(arr, ++p, i);
			}
		}
		swap(arr, low, p);
		return p;
	}
}