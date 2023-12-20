package main.java.org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Пример использования JDBC для взаимодействия с базой данных.
 * Демонстрирует создание таблицы, добавление данных и выполнение запроса.
 */
public class JdbcExample {

    /**
     * Точка входа в программу.
     * Устанавливает соединение с базой данных H2 и выполняет различные операции
     * JDBC.
     */
    public static void main(String[] args) {
        // Параметры подключения к базе данных H2
        String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "";

        try {
            // Установка соединения с базой данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Создание таблицы book
            String createTableSQL = "CREATE TABLE book (id bigint PRIMARY KEY, name varchar(255), author varchar(255))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.executeUpdate();
            }

            // Добавление записей о книгах в таблицу
            String insertSQL = "INSERT INTO book (id, name, author) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                for (int i = 1; i <= 10; i++) {
                    preparedStatement.setLong(1, i);
                    preparedStatement.setString(2, "Book " + i);
                    preparedStatement.setString(3, "Author " + i);
                    preparedStatement.executeUpdate();
                }
            }

            // Выполнение запроса и вывод результатов
            String selectSQL = "SELECT * FROM book WHERE author = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
                preparedStatement.setString(1, "Author 5");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Book: id=" + resultSet.getLong("id") +
                                ", name=" + resultSet.getString("name") +
                                ", author=" + resultSet.getString("author"));
                    }
                }
            }

            // Закрытие соединения с базой данных
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
