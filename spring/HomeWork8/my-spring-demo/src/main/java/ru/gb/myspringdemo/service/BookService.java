package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.aspect.RecoverException;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Timer
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    @Timer
    @Transactional
    @RecoverException(noRecoverFor = {IllegalArgumentException.class})
    public Book addNewBook(BookRequest request) {
        if (bookRepository.findBookByName(request.getName()) != null) {
            throw new IllegalArgumentException("Экземпляр данной книги уже есть");
        }
        Book book = new Book(request.getName());
        bookRepository.save(book);
        return book;
    }

    @Timer
    public Book showBookInfo(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Книга с id: " + id + " не найдена"));
    }

    @Timer
    @Transactional
    @RecoverException(noRecoverFor = {NoSuchElementException.class})
    public Book deleteBook(long id) {
        Book book = showBookInfo(id);
        bookRepository.deleteById(id);
        return book;
    }
}
