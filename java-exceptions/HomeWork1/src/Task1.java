import java.util.Random;

public class Task1 {

    public static void main(String[] args) {

        String[] strArray = {"first string", null, "third string"};
        int[] array = fillArray(12);
        System.out.println("Создаваемое исключение:");
        divideNums(10, 0);
        findElemIndex(array, 12);
        printString(strArray);
    }

    public static void divideNums(double firstNum, double secondNum) {

        if (secondNum == 0) {
            throw new ArithmeticException("На ноль делить нельзя.");
        }
        double result = firstNum / secondNum;
        System.out.printf("Результат деления %f на %f = %f.\n", firstNum, secondNum, result);
    }

    public static void findElemIndex(int[] array, int index) {

        if (index > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Элемент c индексом " + index + " отсутствует.");
        }
        System.out.printf("Элемент с индексом %d равен %d.\n", index, array[index]);
    }

    public static int[] fillArray(int len) {

        int[] array = new int[len];
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(1, 10);
        }
        return array;
    }

    public static void printString(String[] str) {

        int len = str.length;

        for (int i = 0; i < len; i++) {
            if (str[i] == null) {
                throw new NullPointerException("Элемент строки с индексом " + i + " отсутствует.");
            }
            System.out.println(str[i]);
        }
    }
}
