import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите целое неотрицательное число: ");

		int n = scan.nextInt();
		scan.close();

		if (n < 0) {
			System.out.println("Последовательность треугольных чисел начинается с нуля.");
			System.out.println("Повторите ввод!");
		} else {
			System.out.print("Его треугольное число = " + TriangNum.calculate(n));
		}
	}
}
