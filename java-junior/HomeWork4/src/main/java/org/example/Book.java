package main.java.org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Класс {@code Book} моделирует сущность книги для взаимодействия с базой
 * данных.
 * Содержит информацию о названии книги и её авторе.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор книги

    private String name; // Название книги
    private String author; // Автор книги

    /**
     * Конструктор без параметров, необходим для корректной работы Hibernate.
     */
    public Book() {
    }

    /**
     * Конструктор для создания экземпляра книги.
     *
     * @param name   Название книги.
     * @param author Автор книги.
     */
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Стандартные геттеры и сеттеры

    /**
     * Возвращает идентификатор книги.
     *
     * @return Идентификатор книги.
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает название книги.
     *
     * @return Название книги.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название книги.
     *
     * @param name Название книги.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает автора книги.
     *
     * @return Автор книги.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author Автор книги.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Возвращает строковое представление объекта Book.
     *
     * @return Строковое представление информации о книге.
     */
    @Override
    public String toString() {
        return String.format("Book{id=%d, name='%s', author='%s'}", id, name, author);
    }
}
