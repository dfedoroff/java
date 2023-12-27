package org.example;

/**
 * Главный класс приложения, отвечающий за запуск сервера и клиентов.
 * Использует многопоточность для запуска сервера и клиентов в отдельных
 * потоках.
 */
public class Main {
    public static void main(String[] args) {
        // Запуск сервера в отдельном потоке
        new Thread(() -> {
            try {
                Server.main(new String[] {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Пауза для убеждения, что сервер запустился перед подключением клиента
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Создание и запуск демонстрационного клиента
        try {
            Client.main(new String[] { "client" });
            Client.main(new String[] { "admin" }); // Добавление администратора
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
