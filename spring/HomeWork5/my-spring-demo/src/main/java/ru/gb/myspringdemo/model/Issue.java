package ru.gb.myspringdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private final Long bookId;

    @Column(name = "reader_id")
    private final Long readerId;

    @Column(name = "issued_at")
    private final LocalDateTime issued_at = LocalDateTime.now();

    @Column(name = "returned_at")
    private LocalDateTime returned_at;
}
