public class HeapSort {

    public static void buildHeap(int[] arr, int heapLen, int i) {
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
            swap(arr, i, max);
            buildHeap(arr, heapLen, max);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}