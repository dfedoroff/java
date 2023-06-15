package processors;

import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;
import interfaces.ArrayProcessorInterface;

public class ArrayProcessor implements ArrayProcessorInterface {
    private static final int REQUIRED_ARRAY_SIZE = 4;

    @Override
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != REQUIRED_ARRAY_SIZE) {
            throw new MyArraySizeException("Размер массива не " + REQUIRED_ARRAY_SIZE + "x" + REQUIRED_ARRAY_SIZE);
        }

        for (String[] row : array) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeException("Размер массива не " + REQUIRED_ARRAY_SIZE + "x" + REQUIRED_ARRAY_SIZE);
            }
        }

        int sum = 0;
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array[rowIndex].length; columnIndex++) {
                try {
                    sum += Integer.parseInt(array[rowIndex][columnIndex]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + rowIndex + "][" + columnIndex + "]");
                }
            }
        }
        return sum;
    }
}
