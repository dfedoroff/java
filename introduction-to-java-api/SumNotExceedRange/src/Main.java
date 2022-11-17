import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int n = validateIntInput();
		int m = validateIntInput();

		System.out.print(SumCalculation.isWithinRange(n, m));
	}

	public static int validateIntInput() {
		Scanner scan = new Scanner(System.in);

		int num = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print("Введите целое число: ");
			String input = scan.nextLine();

			if (input == null || input.equals("")) {
				throw new IllegalArgumentException("Пустая строка.");
			}

			try {
				num = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("Это не целое число.");
			}
		}
		return num;
	}
}
