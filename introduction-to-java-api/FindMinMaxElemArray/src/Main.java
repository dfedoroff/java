import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.print("Введите размер массива: ");
		int size = validateIntInput();
		int[] array = ArrayManip.createArray(size);
		System.out.println("Оригинальный массив: ");
		ArrayManip.printArray(array);
		ArrayManip.findMinMaxElem(array);
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
				if (n > 0) {
					isValid = true;
				} else {
					System.out.print("Число должно быть положительным: ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Это не целое число.");
				System.out.print("Введите целое число: ");
			}
		}
		scan.close();
		return n;
	}
}
