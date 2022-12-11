import java.util.Random;

public class Task1 {

	public static void main(String[] args) {

		String[] str = {"first string", null, "third string"};
		int[] array = fillArray(12);
	}

	public static int[] fillArray(int len) {

		int[] array = new int[len];
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			array[i] = rand.nextInt(1, 10);
		}
		return array;
	}
}
