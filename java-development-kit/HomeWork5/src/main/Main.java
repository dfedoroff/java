package main;

import philosopher.Philosopher;
import philosopher.ConcretePhilosopher;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск симуляции обедающих философов...");

        // Количество философов
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        // Семафор для контроля доступа к столу
        Semaphore table = new Semaphore(numPhilosophers - 1);

        // Инициализация и запуск потоков философов
        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new ConcretePhilosopher(i, table);
            new Thread((Runnable) philosophers[i]).start();
        }
    }
}
