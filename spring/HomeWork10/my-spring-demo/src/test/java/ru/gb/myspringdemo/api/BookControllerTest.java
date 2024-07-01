package ru.gb.myspringdemo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBooks() {
        List<Book> books = Arrays.asList(new Book("Book1"), new Book("Book2"));
        when(bookService.showAllBooks()).thenReturn(books);

        ResponseEntity<List<Book>> response = bookController.getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }

    @Test
    void getBookInfo() {
        Book book = new Book("Test Book");
        when(bookService.showBookInfo(1L)).thenReturn(book);

        ResponseEntity<Book> response = bookController.getBookInfo(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void getBookInfoNotFound() {
        when(bookService.showBookInfo(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Book> response = bookController.getBookInfo(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void deleteBook() {
        Book book = new Book("Book to delete");
        when(bookService.deleteBook(1L)).thenReturn(book);

        ResponseEntity<Book> response = bookController.deleteBook(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void deleteBookNotFound() {
        when(bookService.deleteBook(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Book> response = bookController.deleteBook(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void addNewBook() {
        BookRequest request = new BookRequest();
        request.setName("New Book");
        Book newBook = new Book("New Book");
        when(bookService.addNewBook(request)).thenReturn(newBook);

        ResponseEntity<Book> response = bookController.addNewBook(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newBook, response.getBody());
    }

    @Test
    void addNewBookConflict() {
        BookRequest request = new BookRequest();
        request.setName("Existing Book");
        when(bookService.addNewBook(request)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Book> response = bookController.addNewBook(request);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }
}