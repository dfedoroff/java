package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс клиента, который подключается к серверу и обменивается сообщениями.
 * Поддерживает функционал как обычного клиента, так и административного
 * клиента.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        final Socket client = new Socket("localhost", Server.PORT);

        // Определение, является ли клиент админом
        boolean isAdmin = args.length > 0 && "admin".equals(args[0]);

        // Поток для чтения сообщений от сервера
        new Thread(() -> {
            try (Scanner input = new Scanner(client.getInputStream())) {
                while (true) {
                    System.out.println(input.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // Поток для отправки сообщений серверу
        new Thread(() -> {
            try (PrintWriter output = new PrintWriter(client.getOutputStream(), true)) {
                Scanner consoleScanner = new Scanner(System.in);
                while (true) {
                    String consoleInput = consoleScanner.nextLine();

                    // Добавление административного токена к сообщению, если клиент - админ
                    if (isAdmin) {
                        consoleInput = "admin_secret " + consoleInput;
                    }

                    output.println(consoleInput);

                    // Закрытие клиента при вводе "q"
                    if ("q".equals(consoleInput)) {
                        client.close();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
