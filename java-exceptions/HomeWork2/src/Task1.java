import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        float fNum = inputFloat();
    }

    public static float inputFloat() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String input = scan.next();

        while (!input.matches("[+-]?[0-9]+\\.[0-9]+")) {
            System.out.println("Это не дробное число.");
            System.out.print("Повторите ввод: ");
            input = scan.next();
        }
        scan.close();
        return Float.parseFloat(input);
    }
}
