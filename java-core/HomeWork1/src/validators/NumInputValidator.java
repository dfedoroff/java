package validators;

import java.util.Scanner;

public class NumInputValidator implements InputValidator, AutoCloseable {

    private static final String INTEGER_REGEX = "^-?\\d+$";
    private static final String INVALID_INPUT_MESSAGE = "Вы не ввели целое число. Попробуйте снова: ";

    private Scanner scan = new Scanner(System.in);

    public Integer validate() {
        String input = scan.nextLine();

        while (input.trim().isEmpty() || !input.matches(INTEGER_REGEX)) {
            System.out.println(INVALID_INPUT_MESSAGE);
            input = scan.nextLine();
        }
        return Integer.parseInt(input);
    }

    @Override
    public void close() {
        scan.close();
    }
}