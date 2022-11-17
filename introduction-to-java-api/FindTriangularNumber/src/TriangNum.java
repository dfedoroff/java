public class TriangNum {
    public static void calculate(int n) {

		int triangular;

	    if (n >= 0) {
		    triangular = n * (n + 1) / 2;
		    System.out.print("Его треугольное число: " + triangular);
	    } else {
		    System.out.println("Последовательность треугольных чисел начинается с ноля. Повторите ввод ...");
		}
	}
}
