package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Reader;

/**
 * Репозиторий для работы с сущностью Reader.
 * Предоставляет методы для выполнения CRUD операций с читателями.
 */
@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    /**
     * Находит читателя по его имени.
     * @param name имя читателя
     * @return читателя с указанным именем или null, если такого читателя нет
     */
    Reader findReaderByName(String name);

}