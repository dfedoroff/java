package ru.gb.myspringdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * Сущность, представляющая выдачу книги читателю.
 * Хранит информацию о выданных книгах, читателях и датах выдачи/возврата.
 */
@Entity
@Table(name = "issues")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Выдача")
public class Issue {

    /** Счетчик для генерации уникальных идентификаторов выдач */
    public static long sequence = 1L;

    /** Уникальный идентификатор выдачи */
    @Id
    @Schema(name = "Идентификатор выдачи")
    private final long id;

    /** Идентификатор выданной книги */
    @Column(name = "book_id")
    @Schema(name = "Идентификатор книги")
    private final long bookId;

    /** Идентификатор читателя, которому выдана книга */
    @Column(name = "reader_id")
    @Schema(name = "Идентификатор читателя")
    private final long readerId;

    /** Дата и время выдачи книги */
    @Column(name = "issued_at")
    @Schema(name = "Дата выдачи")
    private final LocalDateTime issued_at;

    /** Дата и время возврата книги */
    @Column(name = "returned_at")
    @Schema(name = "Дата возврата")
    private LocalDateTime returned_at;

    /**
     * Конструктор для создания новой выдачи.
     * @param bookId идентификатор выдаваемой книги
     * @param readerId идентификатор читателя
     */
    public Issue(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issued_at = LocalDateTime.now();
    }
}