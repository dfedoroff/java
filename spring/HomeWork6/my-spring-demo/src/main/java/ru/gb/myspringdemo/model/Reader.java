package ru.gb.myspringdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "readers")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(name = "Читатель")
public class Reader {

    public static long sequence = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Идентификатор")
    private final long id;

    @Column(name = "name")
    @Schema(name = "Имя", minLength = 1)
    private final String name;

    public Reader(String name) {
        this(sequence++, name);
    }
}
