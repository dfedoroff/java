package ru.gb.myspringdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.service.BookService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Получен запрос актуального списка книг");
        return new ResponseEntity<>(bookService.showAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookInfo(@PathVariable long id) {
        log.info("Получен запрос информации о книге: Id = {}", id);
        final Book book;
        try {
            book = bookService.showBookInfo(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        log.info("Получен запрос на удаление книги: Id = {}", id);
        final Book book;
        try {
            book = bookService.deleteBook(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody BookRequest request) {
        log.info("Получен запрос на добавление книги: name = {}", request.getName());
        final Book book;
        try {
            book = bookService.addNewBook(request);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
}
