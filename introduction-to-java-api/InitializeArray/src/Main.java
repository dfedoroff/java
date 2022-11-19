import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.print("Введите размер массива: ");
		int len = validateIntInput();
		System.out.print("Введите одно значение для всех элементов массива: ");
		int initialValue = validateIntInput();
		int[] array = ArrayManip.createArray(len, initialValue);
		System.out.print("Массив: ");
		ArrayManip.printArray(array);
	}

	public static int validateIntInput() {
		Scanner scan = new Scanner(System.in);

		int n = 0;
		boolean isValid = false;

		while (!isValid) {
			String input = scan.nextLine();

			if (input == null || input.equals("")) {
				throw new IllegalArgumentException("Пустая строка.");
			}

			try {
				n = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("Это не целое число.");
				System.out.print("Введите целое число: ");
			}
		}
		return n;
	}
}
