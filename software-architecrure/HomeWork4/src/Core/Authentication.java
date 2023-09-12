package Data;

import Models.User;

/**
 * Класс для аутентификации пользователей.
 */
public class Authentication {

    /**
     * Метод для аутентификации пользователя по его имени и хешу пароля.
     *
     * @param userProvider предоставляет доступ к данным пользователей
     * @param userName     имя пользователя
     * @param passwordHash хеш пароля пользователя
     * @return объект пользователя, если аутентификация прошла успешно, иначе - null
     * @throws RuntimeException если произошла ошибка аутентификации
     */
    public static User authentication(UserProvider userProvider, String userName, int passwordHash) {
        User user = userProvider.getUserByName(userName);
        if (user == null) {
            throw new RuntimeException("Ошибка: пользователь с таким именем не найден.");
        }
        if (user.getPasswordHash() != passwordHash) {
            throw new RuntimeException("Ошибка: неверный пароль.");
        }
        return user;
    }
}
