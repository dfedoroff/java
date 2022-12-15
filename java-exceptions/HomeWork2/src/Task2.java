public class Task2 {

    public static void main(String[] args) {

        int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7 };
        int index = 8;
        int d = 0;

        if (intArray == null) {
            throw new RuntimeException("Указатель не может указывать на null.");
        }

        if (index > intArray.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за пределы массива.");
        }

        if (d == 0) {
            throw new ArithmeticException("На ноль делить нельзя.");
        }

        double catchedRes1 = intArray[index] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    }
}
