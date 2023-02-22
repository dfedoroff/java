import java.util.Scanner;

public class InputValidation {

    public static int validateIntInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*$";

        while (!input.matches(regex)) {
            System.out.println("Введенное значение не является целым положительным числом");
            System.out.print("Повторите ввод: ");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}
