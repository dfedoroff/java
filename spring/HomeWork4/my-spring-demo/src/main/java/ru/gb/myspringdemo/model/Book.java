package ru.gb.myspringdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public static long sequence = 1L;

    private long id;
    private String name;
    private int copies; // Поле для количества экземпляров

    public Book(String name) {
        this.id = sequence++;
        this.name = name;
        this.copies = 1; // Инициализация 1 экземпляром
    }
}
