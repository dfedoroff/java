import java.util.Arrays;
import java.util.Random;

public class Task4 {

    public static void main(String[] args) {

        int[] firstArray = fillArray(10);
        System.out.println("Первый массив:");
        printArray(firstArray);
        int[] secondArray = fillArray(10);
        System.out.println("Второй массив:");
        printArray(secondArray);
        System.out.println("Массив частных от целочисленного деления элементов двух входящих массивов:");
        printArray(divideArrays(firstArray, secondArray));

    }

    public static int[] divideArrays(int[] firstArr, int[] secondArr) {

        if (firstArr.length != secondArr.length) {
            throw new RuntimeException("Массивы разной длины.");
        }

        int[] array = new int[firstArr.length];

        for (int i = 0; i < array.length; i++) {
            if (secondArr[i] == 0) {
                throw new RuntimeException("На ноль делить нельзя.");
            }
            array[i] = firstArr[i] / secondArr[i];
        }
        return array;
    }

    public static int[] fillArray(int len) {

        int[] arr = new int[len];
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(0, 10);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
