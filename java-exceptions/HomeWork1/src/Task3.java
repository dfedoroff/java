import java.util.Arrays;
import java.util.Random;

public class Task3 {

	public static void main(String[] args) {

		int[] firstArray = fillArray(10);
		System.out.println("Первый массив:");
		printArray(firstArray);
		int[] secondArray = fillArray(10);
		System.out.println("Второй массив:");
		printArray(secondArray);
		System.out.println("Массив разницы элементов двух входящих массивов:");
		printArray(diffArrays(firstArray, secondArray));
	}

	public static int[] diffArrays(int[] firstArr, int[] secondArr) {

		if (firstArr == null || secondArr == null) {
			throw new RuntimeException("Один из входящих массивов равен null.");
		}

		if (firstArr.length != secondArr.length) {
			throw new RuntimeException("Массивы разной длины.");
		}

		int[] array = new int[firstArr.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = firstArr[i] - secondArr[i];
		}
		return array;
	}

	public static int[] fillArray(int len) {

		int[] array = new int[len];
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			array[i] = rand.nextInt(1, 10);
		}
		return array;
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
