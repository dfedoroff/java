import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		String myStr = validateStrInput();
		System.out.print(PalindromeValid.isPalindrome(myStr));
	}

	public static String validateStrInput() {
		Scanner scan = new Scanner(System.in);

		String str = "";
		boolean isValid = false;

		while (!isValid) {
			System.out.print("Введите палиндром: ");
			String input = scan.nextLine();

			if ((input != null) && (!input.equals(""))) {
				str = input;
				isValid = true;
			} else {
				System.out.println("Вы ничего не ввели.");
			}
		}
		return str;
	}
}
