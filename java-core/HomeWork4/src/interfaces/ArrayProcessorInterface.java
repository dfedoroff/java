package interfaces;

import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;

public interface ArrayProcessorInterface {
    int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException;
}

