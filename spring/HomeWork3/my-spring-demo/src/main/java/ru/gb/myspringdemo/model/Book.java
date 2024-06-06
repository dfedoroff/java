package ru.gb.myspringdemo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {

    public static long sequence = 1L;

    private final long id;
    private final String name;

    public Book(String name) {
        this(sequence++, name);
    }
}
