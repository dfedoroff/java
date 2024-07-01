package ru.gb.myspringdemo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.service.BookService;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.service.ReaderService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UiControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private ReaderService readerService;

    @Mock
    private IssueService issueService;

    @Mock
    private Model model;

    @InjectMocks
    private UiController uiController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHome() {
        String viewName = uiController.home();
        assertEquals("home", viewName, "Метод home должен вернуть представление 'home'");
    }

    @Test
    void testGetBooks() {
        // Подготовка
        List<Book> expectedBooks = Arrays.asList(
                new Book("Book1"),
                new Book("Book2")
        );
        when(bookService.showAllBooks()).thenReturn(expectedBooks);

        // Действие
        String viewName = uiController.getBooks(model);

        // Проверка
        assertEquals("books", viewName, "Метод getBooks должен вернуть представление 'books'");
        verify(model).addAttribute("books", expectedBooks);
        verify(bookService).showAllBooks();
    }

    @Test
    void testGetReaders() {
        // Подготовка
        List<Reader> expectedReaders = Arrays.asList(
                new Reader("Reader1"),
                new Reader("Reader2")
        );
        when(readerService.showAllReaders()).thenReturn(expectedReaders);

        // Действие
        String viewName = uiController.getReaders(model);

        // Проверка
        assertEquals("readers", viewName, "Метод getReaders должен вернуть представление 'readers'");
        verify(model).addAttribute("readers", expectedReaders);
        verify(readerService).showAllReaders();
    }

    @Test
    void testGetIssues() {
        // Подготовка
        List<Issue> expectedIssues = Arrays.asList(
                new Issue(1L, 1L),
                new Issue(2L, 2L)
        );
        when(issueService.showAllIssues()).thenReturn(expectedIssues);

        // Действие
        String viewName = uiController.getIssues(model);

        // Проверка
        assertEquals("issues", viewName, "Метод getIssues должен вернуть представление 'issues'");
        verify(model).addAttribute("issues", expectedIssues);
        verify(issueService).showAllIssues();
    }

    @Test
    void testGetIssuesByReaderId() {
        // Подготовка
        long readerId = 1L;
        Reader expectedReader = new Reader("Test Reader");
        List<Issue> expectedIssues = Arrays.asList(
                new Issue(1L, readerId),
                new Issue(2L, readerId)
        );
        List<Book> expectedBooks = Arrays.asList(
                new Book("Book1"),
                new Book("Book2")
        );

        when(readerService.showReaderInfo(readerId)).thenReturn(expectedReader);
        when(issueService.getAllIssuesByReader(readerId)).thenReturn(expectedIssues);
        when(bookService.showBookInfo(1L)).thenReturn(expectedBooks.get(0));
        when(bookService.showBookInfo(2L)).thenReturn(expectedBooks.get(1));

        // Действие
        String viewName = uiController.getIssuesByReaderId(readerId, model);

        // Проверка
        assertEquals("booksByReader", viewName, "Метод getIssuesByReaderId должен вернуть представление 'booksByReader'");
        verify(model).addAttribute("reader", expectedReader);
        verify(model).addAttribute("issues", expectedIssues);
        verify(model).addAttribute("books", expectedBooks);
        verify(readerService).showReaderInfo(readerId);
        verify(issueService).getAllIssuesByReader(readerId);
        verify(bookService, times(2)).showBookInfo(anyLong());
    }

    @Test
    void testGetIssuesByReaderIdWhenReaderNotFound() {
        // Подготовка
        long readerId = 1L;
        when(readerService.showReaderInfo(readerId)).thenThrow(new NoSuchElementException("Reader not found"));

        // Действие и проверка
        assertThrows(NoSuchElementException.class, () -> uiController.getIssuesByReaderId(readerId, model),
                "Должно быть выброшено исключение NoSuchElementException, когда читатель не найден");
        verify(readerService).showReaderInfo(readerId);
        verifyNoInteractions(issueService, bookService);
    }

    @Test
    void testGetIssuesByReaderIdWhenNoIssues() {
        // Подготовка
        long readerId = 1L;
        Reader expectedReader = new Reader("Test Reader");
        when(readerService.showReaderInfo(readerId)).thenReturn(expectedReader);
        when(issueService.getAllIssuesByReader(readerId)).thenReturn(List.of());

        // Действие
        String viewName = uiController.getIssuesByReaderId(readerId, model);

        // Проверка
        assertEquals("booksByReader", viewName, "Должно вернуться представление 'booksByReader' даже если у читателя нет выдач");
        verify(model).addAttribute("reader", expectedReader);
        verify(model).addAttribute("issues", List.of());
        verify(model).addAttribute("books", List.of());
        verify(readerService).showReaderInfo(readerId);
        verify(issueService).getAllIssuesByReader(readerId);
        verifyNoInteractions(bookService);
    }
}