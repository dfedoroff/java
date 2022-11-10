public class QuickSort {
	static void swap(int[] arr, int low, int pivot) {

		int temp = arr[low];
		arr[low] = arr[pivot];
		arr[pivot] = temp;
	}
}