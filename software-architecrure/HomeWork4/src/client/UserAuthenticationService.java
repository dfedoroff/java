package client;

import service.UserManagementService;
import models.User;

/**
 * Класс, отвечающий за аутентификацию пользователя в системе.
 * Содержит методы для проверки введенных пользователем данных (логин и хеш пароля)
 * на соответствие данным, хранящимся в базе данных.
 */
public class UserAuthenticationService {

    /**
     * Метод для аутентификации пользователя.
     * Производит поиск пользователя в базе данных по логину и сравнивает хеш введенного пароля с хешем, хранящимся в базе данных.
     *
     * @param userManagementService сервис для работы с данными пользователей
     * @param login логин пользователя
     * @param passHash хеш пароля пользователя
     * @return объект пользователя, если аутентификация прошла успешно
     * @throws RuntimeException если аутентификация не удалась (неверный логин или пароль)
     */
    public static User authentication(UserManagementService userManagementService, String login, int passHash) {
        var client = userManagementService.getClientByName(login);
        if (client.getHashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Ошибка аутентификации: неверный логин или пароль");
        }
    }
}
