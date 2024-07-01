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
 * Сущность, представляющая читателя в системе.
 * Используется для хранения информации о читателях библиотеки.
 */
@Entity
@Table(name = "readers")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Читатель")
public class Reader {

    /** Счетчик для генерации уникальных идентификаторов читателей */
    public static long sequence = 1L;

    /** Уникальный идентификатор читателя */
    @Id
    @Schema(name = "Идентификатор")
    private final long id;

    /** Имя читателя */
    @Column(name = "name")
    @Schema(name = "Имя", minLength = 1)
    private final String name;

    /**
     * Конструктор для создания нового читателя с автоматически сгенерированным id.
     * @param name имя читателя
     */
    public Reader(String name) {
        this(sequence++, name);
    }
}