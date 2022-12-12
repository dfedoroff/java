import java.util.Arrays;
import java.util.Random;

public class Task4 {

	public static void main(String[] args) {

		int[] firstArray = fillArray(10);
		System.out.println("Первый массив:");
		printArray(firstArray);
		int[] secondArray = fillArray(9);
		System.out.println("Второй массив:");
		printArray(secondArray);
	}

	public static int[] fillArray(int len) {

		int[] arr = new int[len];
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			arr[i] = rand.nextInt(1, 10);
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
