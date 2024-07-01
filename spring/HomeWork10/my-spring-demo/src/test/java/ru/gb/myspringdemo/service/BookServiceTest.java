package ru.gb.myspringdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowAllBooks() {
        List<Book> books = Arrays.asList(new Book("Book1"), new Book("Book2"));
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.showAllBooks();

        assertEquals(2, result.size());
        assertEquals("Book1", result.get(0).getName());
        assertEquals("Book2", result.get(1).getName());
    }

    @Test
    void testAddNewBook() {
        BookRequest request = new BookRequest();
        request.setName("New Book");
        when(bookRepository.findBookByName("New Book")).thenReturn(null);
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Book result = bookService.addNewBook(request);

        assertNotNull(result);
        assertEquals("New Book", result.getName());
    }

    @Test
    void testAddNewBookAlreadyExists() {
        BookRequest request = new BookRequest();
        request.setName("Existing Book");
        when(bookRepository.findBookByName("Existing Book")).thenReturn(new Book("Existing Book"));

        assertThrows(IllegalArgumentException.class, () -> bookService.addNewBook(request));
    }

    @Test
    void testShowBookInfo() {
        Book book = new Book("Test Book");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.showBookInfo(1L);

        assertEquals("Test Book", result.getName());
    }

    @Test
    void testShowBookInfoNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> bookService.showBookInfo(1L));
    }

    @Test
    void testDeleteBook() {
        Book book = new Book("Book to Delete");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.deleteBook(1L);

        assertEquals("Book to Delete", result.getName());
        verify(bookRepository, times(1)).deleteById(1L);
    }
}