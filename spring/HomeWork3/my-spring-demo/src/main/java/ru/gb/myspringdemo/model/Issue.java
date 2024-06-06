package ru.gb.myspringdemo.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
public class Issue {

    public static long sequence = 1L;

    private final long id;
    private final long bookId;
    private final long readerId;
    private final LocalDateTime issued_at;  // Дата выдачи
    private LocalDateTime returned_at;      // Дата возврата

    public Issue(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issued_at = LocalDateTime.now();
    }
}
