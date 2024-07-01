package ru.gb.myspringdemo.api;

import lombok.Data;

/**
 * Класс, представляющий запрос на выдачу книги.
 * Содержит информацию, необходимую для регистрации выдачи книги читателю.
 */
@Data
public class IssueRequest {

    /** Идентификатор читателя, которому выдается книга */
    private long readerId;

    /** Идентификатор книги, которая выдается */
    private long bookId;
}