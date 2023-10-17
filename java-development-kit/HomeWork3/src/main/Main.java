package main;

import database.DataBase;
import utils.Pair;

import java.util.Scanner;

/**
 * Главный класс для демонстрации работы базы данных и класса Pair.
 */
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("h", 3);
        System.out.println("Пример использования класса Pair: " + pair);
        System.out.println("========================================");

        DataBase<String> db = new DataBase<>("data.ser");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Меню управления базой данных =====");
            System.out.println("1. Загрузить данные из файла");
            System.out.println("2. Сохранить данные в файл");
            System.out.println("3. Добавить новую запись");
            System.out.println("4. Удалить запись по индексу");
            System.out.println("5. Просмотреть все записи");
            System.out.println("6. Выход");
            System.out.println("========================================");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            System.out.println("========================================");

            switch (choice) {
                case 1:
                    db.load();
                    System.out.println("Данные успешно загружены из файла.");
                    break;
                case 2:
                    db.save();
                    System.out.println("Данные успешно сохранены в файл.");
                    break;
                case 3:
                    System.out.print("Введите данные для новой записи: ");
                    String data = scanner.nextLine();
                    db.add(data);
                    System.out.println("Новая запись успешно добавлена.");
                    break;
                case 4:
                    System.out.print("Введите индекс записи для удаления: ");
                    int index = scanner.nextInt();
                    db.remove(index);
                    break;
                case 5:
                    System.out.println("Текущие записи в базе данных:");
                    for (int i = 0; i < db.size(); i++) {
                        System.out.println(i + ": " + db.get(i));
                    }
                    break;
                case 6:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }

            System.out.println("========================================\n");
        }
    }
}
