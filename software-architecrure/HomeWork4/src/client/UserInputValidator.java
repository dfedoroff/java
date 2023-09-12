package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Абстрактный класс, предназначенный для валидации данных, вводимых пользователем.
 * Содержит методы для ввода и проверки различных типов данных: целых и длинных целых чисел, строк и дат.
 */
public abstract class UserInputValidator {

    /**
     * Метод для ввода и валидации целого числа в заданном диапазоне.
     * Пользователь вводит число, которое проверяется на соответствие заданному диапазону.
     *
     * @param minVariant минимально допустимое значение
     * @param maxVariant максимально допустимое значение
     * @return введенное пользователем целое число
     * @throws RuntimeException если введено значение, выходящее за пределы допустимого диапазона или не являющееся числом
     */
    protected int inputInt(int minVariant, int maxVariant) throws RuntimeException {
        int num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextInt();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("Введено недопустимое значение. Пожалуйста, введите число в диапазоне от " + minVariant + " до " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Введено не число. Попробуйте снова.");
        }
        return num;
    }

    /**
     * Метод для ввода и валидации длинного целого числа в заданном диапазоне.
     * Пользователь вводит число, которое проверяется на соответствие заданному диапазону.
     *
     * @param minVariant минимально допустимое значение
     * @param maxVariant максимально допустимое значение
     * @return введенное пользователем длинное целое число
     * @throws RuntimeException если введено значение, выходящее за пределы допустимого диапазона или не являющееся числом
     */
    protected long inputLong(long minVariant, long maxVariant) throws RuntimeException {
        long num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextLong();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("Введено недопустимое значение. Пожалуйста, введите число в диапазоне от " + minVariant + " до " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Введено не число. Попробуйте снова.");
        }
        return num;
    }

    /**
     * Метод для ввода строки с последующей валидацией на пустую строку.
     * Пользователь вводит строку, которая проверяется на отсутствие текста (только пробелы или пустая строка).
     *
     * @return введенная пользователем строка
     * @throws RuntimeException если введена пустая строка или строка, содержащая только пробелы
     */
    protected String inputString() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.trim().isEmpty()) {
            throw new RuntimeException("Строка не может быть пустой. Попробуйте снова.");
        }
        return str;
    }

    /**
     * Метод для ввода даты с последующей валидацией.
     * Пользователь вводит дату в формате "yyyy-MM-dd", которая проверяется на соответствие этому формату.
     *
     * @return введенная пользователем дата
     * @throws RuntimeException если введена некорректная дата
     */
    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ft.setLenient(false); // Устанавливаем строгую проверку формата даты
        Scanner in = new Scanner(System.in);
        String str;
        Date date;
        try {
            str = in.nextLine();
            date = ft.parse(str);
        } catch (ParseException ex) {
            throw new RuntimeException("Введена некорректная дата. Пожалуйста, введите дату в формате yyyy-MM-dd.");
        }
        return date;
    }
}
