package ru.gb.myspringdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Сущность, представляющая книгу в системе.
 * Используется для хранения информации о книгах в библиотеке.
 */
@Entity
@Table(name = "books")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Книга")
public class Book {

    /** Счетчик для генерации уникальных идентификаторов книг */
    public static long sequence = 1L;

    /** Уникальный идентификатор книги */
    @Id
    @Schema(name = "Идентификатор")
    private final long id;

    /** Название книги */
    @Column(name = "name")
    @Schema(name = "Название", minLength = 1)
    private final String name;

    /**
     * Конструктор для создания новой книги с автоматически сгенерированным id.
     * @param name название книги
     */
    public Book(String name) {
        this(sequence++, name);
    }
}