public class Task2_1 {

    public static void main(String[] args) {

        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int d = 0;

        if (d == 0) {
            throw new ArithmeticException("На ноль делить нельзя.");
        }

        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    }
}
