package repository;

import interfaces.UserDatabaseInterface;
import models.User;
import models.BankAccount;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных пользователей.
 * Реализует интерфейс UserDatabaseInterface.
 */
public class UserRepository implements UserDatabaseInterface {
    private static UserRepository clientRepository;
    private List<User> clients;

    /**
     * Приватный конструктор, обеспечивающий синглтон для репозитория.
     * Инициализирует список клиентов тестовыми данными.
     */
    private UserRepository() {
        // Имитация работы базы данных с клиентами
        clients = new ArrayList<>();
        clients.add(new User(1, "Клиент 1", "1111".hashCode(), 2));
        clients.add(new User(2, "Клиент 2", "2222".hashCode(), 3));
        clients.add(new User(3, "Клиент 3", "3333".hashCode(), 4));
        clients.add(new User(4, "Клиент 4", "4444".hashCode(), 5));
    }

    /**
     * Статический метод для получения экземпляра репозитория (синглтон).
     *
     * @return экземпляр UserRepository
     */
    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (var currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                throw new RuntimeException("Клиент с таким ID уже существует");
            }
        }
        clients.add(client);

        // Создаем новый банковский счет для нового пользователя
        CashRepository cashRepository = CashRepository.getCashRepository();
        BankAccount newAccount = new BankAccount();
        newAccount.setCard(cardNumber); // Устанавливаем номер карты
        newAccount.setBalance(1000); // Устанавливаем начальный баланс, например, 1000
        cashRepository.getClients().add(newAccount);

        return client.getId();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (var client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new RuntimeException("Клиент с таким ID не найден");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (var client : clients) {
            var clientName = client.getUserName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("Клиент с таким именем не найден");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("Список клиентов пуст");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        User tempClient = null;
        for (User currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}
