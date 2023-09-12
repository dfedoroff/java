package models;

import java.util.Objects;

/**
 * Класс, представляющий собой модель пользователя.
 * Хранит информацию об ID пользователя, его имени, хэшированном пароле и номере банковской карты.
 */
public class User {

    private int id; // Уникальный идентификатор пользователя
    private String userName; // Имя пользователя
    private int hashPassword; // Хэш пароля пользователя
    private long cardNumber; // Номер банковской карты пользователя

    /**
     * Конструктор для создания объекта пользователя с заданными параметрами.
     *
     * @param id           уникальный идентификатор пользователя
     * @param userName     имя пользователя
     * @param hashPassword хэш пароля пользователя
     * @param cardNumber   номер банковской карты пользователя
     */
    public User(int id, String userName, int hashPassword, long cardNumber) {
        this.id = id;
        this.userName = userName;
        this.hashPassword = hashPassword;
        this.cardNumber = cardNumber;
    }

    // Геттеры для полей класса с соответствующими комментариями

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getHashPassword() {
        return hashPassword;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    // Переопределенный метод toString с форматированием номера карты

    @Override
    public String toString() {
        return "Клиент { " +
                "id= " + id +
                ", userName= " + userName +
                ", cardNumber= " + (String.format("%016d", cardNumber)) +
                " }";
    }

    // Переопределенные методы equals и hashCode для сравнения объектов и получения хэш-кода объекта

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.equals(user);
    }

    public boolean equals(User user) {
        return id == user.id && hashPassword == user.hashPassword && cardNumber == user.cardNumber && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, hashPassword, cardNumber);
    }
}
