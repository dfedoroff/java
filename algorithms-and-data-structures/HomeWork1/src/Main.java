import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[10];
		int len = array.length;
		int min = -10;
		int max = 10;
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			array[i] = rand.nextInt(max - min + 1) + min;
		}

        System.out.println("Изначальный массив: " + Arrays.toString(array));

        HeapSort.sort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
	}
}