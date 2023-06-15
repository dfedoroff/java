package main;

import processors.ArrayProcessor;
import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "abc", "16"}
        };

        ArrayProcessor arrayProcessor = new ArrayProcessor();
        processArray(arrayProcessor, correctArray);
        processArray(arrayProcessor, incorrectSizeArray);
        processArray(arrayProcessor, incorrectDataArray);
    }

    private static void processArray(ArrayProcessor arrayProcessor, String[][] array) {
        try {
            int sum = arrayProcessor.processArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
