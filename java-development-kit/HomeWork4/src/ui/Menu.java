package ui;

import java.util.Scanner;

public class Menu {
    public void mainMenu() {
        System.out.println("=".repeat(22) + "\n" +
                "Справочник сотрудников\n" +
                "=".repeat(22));
        System.out.println("1 — Просмотр сотрудников\n" +
                "2 — Добавление сотрудника\n" +
                "3 — Поиск по стажу\n" +
                "4 — Поиск по имени\n" +
                "5 — Поиск по ID\n" +
                "6 — Удаление сотрудника\n" +
                "7 — Сохранить в файл\n" +
                "q — Выход");
        System.out.print("Введите номер операции: ");
    }

    public void pressEnter(Scanner scn) {
        System.out.println("Нажмите Enter для продолжения...");
        scn.nextLine();
    }
}
