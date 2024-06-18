package ru.gb.myspringdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "books")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Книга")
public class Book {

    public static long sequence = 1L;

    @Id
    @Schema(name = "Идентификатор")
    private final long id;

    @Column(name = "name")
    @Schema(name = "Название", minLength = 1)
    private final String name;

    public Book(String name) {
        this(sequence++, name);
    }
}
