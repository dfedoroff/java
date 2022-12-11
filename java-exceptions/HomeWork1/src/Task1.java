import java.util.Random;

public class Task1 {

	public static void main(String[] args) {

		String[] str = {"first string", null, "third string"};
		int[] array = fillArray(12);
		System.out.println("Создаваемое исключение:");
		divide(10, 0);
	}

	public static void divide(double firstNum, double secondNum) {

		if (secondNum ==  0) {
			throw new ArithmeticException("На ноль делить нельзя.");
		}
		double result = firstNum / secondNum;
		System.out.printf("Результат деления %f на %f = %f.\n", firstNum, secondNum, result);
	}

	public static void findElemIndex(int[] array, int index) {

		if (index > array.length - 1) {
			throw new ArrayIndexOutOfBoundsException("Элемент c индексом " + index + " отсутствует.");
		} else {
			System.out.printf("Элемент с индексом %d равен %d.\n", index, array[index]);
		}
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
