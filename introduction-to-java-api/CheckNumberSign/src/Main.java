import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int num = validateIntInput();

		System.out.print(SignCheck.isNegative(num));
	}

	public static int validateIntInput() {
		Scanner scan = new Scanner(System.in);

		int n = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print("Введите целое число: ");
			String input = scan.nextLine();

			if (input == null || input.equals("")) {
				throw new IllegalArgumentException("Пустая строка.");
			}

			try {
				n = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("Это не целое число.");
			}
		}
		scan.close();
		return n;
	}
}
