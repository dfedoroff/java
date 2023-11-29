package main;

import generator.NumberGenerator;
import generator.RandomNumberGenerator;
import processor.MaximumFinder;
import processor.NumberProcessor;
import processor.SpecialNumberSummator;
import processor.SquareLessCounter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        List<Integer> numbers = generator.generateNumbers(1000);

        NumberProcessor maxFinder = new MaximumFinder();
        NumberProcessor summator = new SpecialNumberSummator();
        NumberProcessor counter = new SquareLessCounter();

        System.out.println("Максимальное число: " + maxFinder.process(numbers));
        System.out.println("Сумма чисел больше 500000, умноженных на 5 и уменьшенных на 150: " + summator.process(numbers));
        System.out.println("Количество чисел с квадратом меньше 100000: " + counter.process(numbers));
    }
}
