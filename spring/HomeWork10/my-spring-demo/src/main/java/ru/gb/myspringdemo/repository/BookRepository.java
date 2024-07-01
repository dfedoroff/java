package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Book;

/**
 * Репозиторий для работы с сущностью Book.
 * Предоставляет методы для выполнения CRUD операций с книгами.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Находит книгу по её названию.
     * @param name название книги
     * @return книгу с указанным названием или null, если такой книги нет
     */
    Book findBookByName(String name);

}