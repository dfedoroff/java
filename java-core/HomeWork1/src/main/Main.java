package main;

import operations.MathOperations;
import validators.NumInputValidator;

public class Main {

    public static void main(String[] args) {
        try (NumInputValidator numInputValidator = new NumInputValidator()) {
            System.out.print("Введите первое целое число: ");
            int n = numInputValidator.validate();

            System.out.print("Введите второе целое число: ");
            int m = numInputValidator.validate();

            MathOperations mathOperations = new MathOperations();

            System.out.println("Сложение: " + mathOperations.add(n, m));
            System.out.println("Вычитание: " + mathOperations.subtract(n, m));
            System.out.println("Умножение: " + mathOperations.multiply(n, m));
            try {
                System.out.println("Деление: " + mathOperations.divide(n, m));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}