package ru.gb.myspringdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new Reader("Читатель1"),
                new Reader("Читатель2"),
                new Reader("Читатель3")
        ));
    }

    public List<Reader> getAll() {
        return List.copyOf(readers);
    }

    public Reader getReaderById(long id) {
        return readers.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Reader getReaderByName(String name) {
        return readers.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void deleteReader(Reader reader) {
        readers.remove(reader);
    }
}
