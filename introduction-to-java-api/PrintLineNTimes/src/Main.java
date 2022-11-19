import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		String myStr = validateStrInput();
		int myNum = validateIntInput();
	}

	public static int validateIntInput() {
		Scanner scan = new Scanner(System.in);

		int n = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print("Введите целое положительное число: ");
			String input = scan.nextLine();

			if (input == null || input.equals("")) {
				throw new IllegalArgumentException("Пустая строка.");
			}

			try {
				n = Integer.parseInt(input);
				if (n > 0) isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("Это не целое число.");
			}
		}
		return n;
	}

	public static String validateStrInput() {
		Scanner scan = new Scanner(System.in);

		String str = "";
		boolean isValid = false;

		while (!isValid) {
			System.out.print("Введите строку: ");
			String input = scan.nextLine();

			if ((input != null) && (!input.equals("")) && (input.matches("^[\\D ]++$"))) {
				str = input;
				isValid = true;
			} else {
				System.out.println("Это не строка.");
			}
		}
		return str;
	}
}
