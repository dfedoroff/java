package ru.gb.myspringdemo.api;

import lombok.Data;

/**
 * Класс, представляющий запрос на добавление нового читателя.
 * Содержит необходимые данные для создания читателя.
 */
@Data
public class ReaderRequest {

    /** Имя нового читателя */
    private String name;
}