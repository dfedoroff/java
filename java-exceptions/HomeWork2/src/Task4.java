import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустую строку вводить нельзя.");
        }

        System.out.println("Вы ввели: " + input);
        scan.close();
    }
}
