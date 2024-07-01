package ru.gb.myspringdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.service.BookService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * REST-контроллер для управления книгами.
 * Обрабатывает HTTP-запросы, связанные с операциями над книгами.
 */
@Slf4j
@RestController
@RequestMapping("/book")
@Tag(name = "Book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Получает список всех книг.
     * @return ResponseEntity со списком всех книг
     */
    @Timer
    @GetMapping()
    @Operation(summary = "get all books", description = "Загружает список книг, внесённых в систему")
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Получен запрос актуального списка книг");
        return new ResponseEntity<>(bookService.showAllBooks(), HttpStatus.OK);
    }

    /**
     * Получает информацию о конкретной книге по её ID.
     * @param id идентификатор книги
     * @return ResponseEntity с информацией о книге или сообщением об ошибке
     */
    @Timer
    @GetMapping("/{id}")
    @Operation(summary = "get info about book", description = "Загружает информацию о запрашиваемой книге")
    public ResponseEntity<Book> getBookInfo(@PathVariable long id) {
        log.info("Получен запрос информации о книге: Id = {}", id);
        try {
            Book book = bookService.showBookInfo(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет книгу по её ID.
     * @param id идентификатор книги
     * @return ResponseEntity с информацией об удаленной книге или сообщением об ошибке
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "delete book", description = "Удаляет книгу из системы по Id")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        log.info("Получен запрос на удаление книги: Id = {}", id);
        try {
            Book book = bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Добавляет новую книгу в систему.
     * @param request запрос на добавление книги
     * @return ResponseEntity с информацией о добавленной книге или сообщением об ошибке
     */
    @PostMapping
    @Operation(summary = "add new book", description = "Добавляет новую книгу в систему")
    public ResponseEntity<Book> addNewBook(@RequestBody BookRequest request) {
        log.info("Получен запрос на добавление книги: name = {}", request.getName());
        try {
            Book book = bookService.addNewBook(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}