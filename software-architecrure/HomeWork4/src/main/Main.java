package main;

import client.ApplicationStarter;

/**
 * Главный класс приложения, отвечающий за запуск программы.
 * Этот класс содержит метод main, который является точкой входа в приложение.
 */
public class Main {
    /**
     * Метод main, который является точкой входа в приложение.
     * В этом методе создается экземпляр класса ApplicationStarter и вызывается метод runLoginRegisterMenu,
     * который запускает меню входа и регистрации.
     *
     * @param args аргументы командной строки. В текущей версии программы аргументы командной строки не используются.
     */
    public static void main(String[] args) {
        // Создание экземпляра класса ApplicationStarter, который отвечает за запуск основного меню приложения
        ApplicationStarter applicationStarter = new ApplicationStarter();

        // Запуск меню входа и регистрации, где пользователь может войти в систему или зарегистрироваться
        applicationStarter.runLoginRegisterMenu();
    }
}
