package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByName(String name);
}
