package service;

import interfaces.UserDatabaseInterface;
import models.User;
import repository.UserRepository;

import java.util.List;

/**
 * Класс-провайдер для работы с базой данных клиентов.
 * Отвечает за создание новых клиентов и получение информации о существующих клиентах.
 */
public class UserManagementService {
    private UserDatabaseInterface clientRepository;

    /**
     * Конструктор класса, инициализирующий репозиторий для работы с клиентами.
     * Реализует паттерн Singleton для репозитория клиентов.
     */
    public UserManagementService() {
        this.clientRepository = UserRepository.getClientRepository();
    }

    /**
     * Метод для создания нового клиента в базе данных.
     * Проверяет корректность входных данных и создает новую запись в базе данных.
     *
     * @param userName     имя клиента
     * @param passwordHash хэш пароля
     * @param cardNumber   номер банковской карты
     * @return ID нового клиента в базе данных
     * @throws RuntimeException если создание нового клиента не удалось
     */
    public int createClient(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clientRepository.create(userName, passwordHash, cardNumber);
        return id;
    }

    /**
     * Метод для поиска клиента по имени.
     * Проверяет корректность входных данных и возвращает информацию о клиенте.
     *
     * @param userName имя клиента
     * @return объект клиента
     * @throws RuntimeException если клиент с указанным именем не найден
     */
    public User getClientByName(String userName) throws RuntimeException {
        var client = clientRepository.read(userName);
        return client;
    }

    /**
     * Метод для получения списка всех клиентов.
     * Используется для администрирования и тестирования системы.
     *
     * @return список всех клиентов
     * @throws RuntimeException если получить список клиентов не удалось
     */
    public List<User> getAllClients() throws RuntimeException {
        var clients = clientRepository.readAll();
        return clients;
    }
}
