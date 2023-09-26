package main;

import models.TableModel;
import presenters.BookingPresenter;
import presenters.Model;
import presenters.View;
import views.BookingView;

import java.util.Date;
import java.util.Scanner;

/**
 * Главный класс, запускающий приложение.
 */
public class Main {
    public static void main(String[] args) {
        // Инициализация View, Model и Presenter
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        // Обновление UI для отображения столов
        presenter.updateUIShowTables();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Бронирование столика на имя Татьяна
                    view.reservationTable(new Date(), 2, "Татьяна");
                    break;
                case 2:
                    // Бронирование столика на имя Сергей
                    view.reservationTable(new Date(), 3, "Сергей");
                    break;
                case 3:
                    // Изменение бронирования столика из брони #1001 на имя Наталья
                    view.changeReservationTable(1001, new Date(), 4, "Наталья");
                    break;
                case 4:
                    // Выход из программы
                    System.out.println("Выход из программы");
                    return;
                case 5:
                    // Показ всех бронирований
                    presenter.updateUIShowReservations();
                    break;
                default:
                    // Неверный выбор
                    System.out.println("Неверный выбор, пожалуйста, попробуйте снова");
            }
        }
    }

    /**
     * Метод для отображения меню.
     */
    private static void displayMenu() {
        System.out.println("1. Забронировать столик на имя Татьяна");
        System.out.println("2. Забронировать столик на имя Сергей");
        System.out.println("3. Изменить бронирование столика из брони #1001 на имя Наталья");
        System.out.println("4. Выход");
        System.out.println("5. Показать все бронирования");
        System.out.print("Введите ваш выбор: ");
    }
}
