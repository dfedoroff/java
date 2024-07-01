package ru.gb.myspringdemo.api;

import lombok.Data;

/**
 * Класс, представляющий запрос на добавление новой книги.
 * Содержит необходимые данные для создания книги.
 */
@Data
public class BookRequest {

    /** Название новой книги */
    private String name;
}