package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс сервера, который принимает подключения от клиентов и обрабатывает их
 * сообщения.
 * Поддерживает личные и общие сообщения, а также административные команды.
 */
public class Server {
    public static final int PORT = 8181;
    private static long clientIdCounter = 1L;
    private static Map<Long, SocketWrapper> clients = new HashMap<>();
    private static final String ADMIN_TOKEN = "admin_secret";

    /**
     * Основной метод сервера, отвечающий за принятие подключений от клиентов.
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket client = server.accept();
                long clientId = clientIdCounter++;
                SocketWrapper wrapper = new SocketWrapper(clientId, client, false);
                clients.put(clientId, wrapper);

                new Thread(() -> handleClient(wrapper)).start();
            }
        }
    }

    /**
     * Метод для обработки сообщений от клиента.
     * Распознает административные команды и личные сообщения.
     *
     * @param wrapper Обертка сокета клиента.
     */
    private static void handleClient(SocketWrapper wrapper) {
        long clientId = wrapper.getId();
        try (Scanner input = wrapper.getInput(); PrintWriter output = wrapper.getOutput()) {
            output.println("Подключение успешно. Ваш ID: " + clientId);

            while (true) {
                String clientInput = input.nextLine();

                // Обработка административного токена
                if (clientInput.startsWith(ADMIN_TOKEN)) {
                    wrapper.setAdmin(true);
                    clientInput = clientInput.substring(ADMIN_TOKEN.length()).trim();
                }

                // Обработка команды кика
                if (wrapper.isAdmin() && clientInput.startsWith("kick ")) {
                    long targetId = Long.parseLong(clientInput.split(" ")[1]);
                    kickClient(targetId);
                    continue;
                }

                // Обработка личных сообщений
                if (clientInput.startsWith("@")) {
                    long destinationId = Long.parseLong(clientInput.substring(1, clientInput.indexOf(' ')));
                    String message = clientInput.substring(clientInput.indexOf(' ') + 1);
                    sendMessageToClient(destinationId, "Личное сообщение от [" + clientId + "]: " + message);
                } else {
                    // Отправка общих сообщений
                    clients.values().stream()
                            .filter(it -> it.getId() != clientId)
                            .forEach(it -> it.getOutput().println("Сообщение от [" + clientId + "]: " + clientInput));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            clients.remove(clientId);
        }
    }

    /**
     * Метод для отключения клиента по его идентификатору.
     *
     * @param clientId Идентификатор клиента для отключения.
     */
    private static void kickClient(long clientId) {
        SocketWrapper client = clients.remove(clientId);
        if (client != null) {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод для отправки личного сообщения клиенту.
     *
     * @param clientId Идентификатор клиента, которому отправляется сообщение.
     * @param message  Сообщение для отправки.
     */
    private static void sendMessageToClient(long clientId, String message) {
        SocketWrapper client = clients.get(clientId);
        if (client != null) {
            client.getOutput().println(message);
        }
    }
}

/**
 * Вспомогательный класс для управления сокетами клиентов.
 * Хранит информацию об идентификаторе клиента, сокете, потоках ввода-вывода и
 * статусе администратора.
 */
class SocketWrapper implements AutoCloseable {
    private final long id;
    private final Socket socket;
    private final Scanner input;
    private final PrintWriter output;
    private boolean isAdmin;

    SocketWrapper(long id, Socket socket, boolean isAdmin) throws IOException {
        this.id = id;
        this.socket = socket;
        this.input = new Scanner(socket.getInputStream());
        this.output = new PrintWriter(socket.getOutputStream(), true);
        this.isAdmin = isAdmin;
    }

    // Геттеры и сеттеры для доступа к полям класса

    @Override
    public void close() throws Exception {
        socket.close();
    }
}
