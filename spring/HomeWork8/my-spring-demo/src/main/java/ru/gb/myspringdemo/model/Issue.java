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
 * Запись о факте выдачи книги (в БД)
 */
@Entity
@Table(name = "issues")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Выдача")
public class Issue {

    public static long sequence = 1L;

    @Id
    @Schema(name = "Идентификатор выдачи")
    private final long id;

    @Column(name = "book_id")
    @Schema(name = "Идентификатор книги")
    private final long bookId;

    @Column(name = "reader_id")
    @Schema(name = "Идентификатор читателя")
    private final long readerId;

    @Column(name = "issued_at")
    @Schema(name = "Дата выдачи")
    private final LocalDateTime issued_at;

    @Column(name = "returned_at")
    @Schema(name = "Дата возврата")
    private LocalDateTime returned_at;

    public Issue(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issued_at = LocalDateTime.now();
    }
}
