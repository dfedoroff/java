package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Сервис для управления книгами.
 * Реализует бизнес-логику работы с книгами.
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Получает список всех книг.
     * @return список всех книг
     */
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Добавляет новую книгу.
     * @param request запрос на добавление книги
     * @return добавленная книга
     * @throws IllegalArgumentException если книга с таким названием уже существует
     */
    public Book addNewBook(BookRequest request) {
        if (bookRepository.findBookByName(request.getName()) != null) {
            throw new IllegalArgumentException("Экземпляр данной книги уже есть");
        }
        Book book = new Book(request.getName());
        return bookRepository.save(book);
    }

    /**
     * Получает информацию о книге по её ID.
     * @param id идентификатор книги
     * @return информация о книге
     * @throws NoSuchElementException если книга не найдена
     */
    public Book showBookInfo(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Книга с id: " + id + " не найдена"));
    }

    /**
     * Удаляет книгу по её ID.
     * @param id идентификатор книги
     * @return удаленная книга
     * @throws NoSuchElementException если книга не найдена
     */
    public Book deleteBook(long id) {
        Book book = showBookInfo(id);
        bookRepository.deleteById(id);
        return book;
    }
}