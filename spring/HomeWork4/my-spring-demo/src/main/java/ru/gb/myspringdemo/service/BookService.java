package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> showAllBooks() {
        return bookRepository.getAll();
    }

    public Book addNewBook(BookRequest request) {
        Book book = bookRepository.getBookByName(request.getName());
        if (book != null) {
            bookRepository.incrementCopies(book);
        } else {
            book = new Book(request.getName());
            bookRepository.addBook(book);
        }
        return book;
    }

    public Book showBookInfo(long id) {
        Book book = bookRepository.getBookById(id);
        if (book == null) {
            throw new NoSuchElementException("Книга с id: " + id + " не найдена");
        }
        return book;
    }

    public Book deleteBook(long id) {
        Book book = bookRepository.getBookById(id);
        if (book == null) {
            throw new NoSuchElementException("Книга с id: " + id + " не найдена");
        }
        bookRepository.decrementCopies(book);
        if (book.getCopies() == 0) {
            bookRepository.deleteBook(book);
        }
        return book;
    }
}
