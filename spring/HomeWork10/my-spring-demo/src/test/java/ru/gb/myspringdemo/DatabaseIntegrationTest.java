package ru.gb.myspringdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.repository.BookRepository;
import ru.gb.myspringdemo.repository.ReaderRepository;
import ru.gb.myspringdemo.repository.IssueRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class DatabaseIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void testDatabaseOperations() {
        // Создание и сохранение книги
        Book book = new Book("Test Book");
        book = bookRepository.save(book);
        assertNotNull(book.getId());

        // Создание и сохранение читателя
        Reader reader = new Reader("Test Reader");
        reader = readerRepository.save(reader);
        assertNotNull(reader.getId());

        // Создание выдачи
        Issue issue = new Issue(book.getId(), reader.getId());
        issue = issueRepository.save(issue);
        assertNotNull(issue.getId());

        // Проверка получения данных
        Optional<Book> retrievedBook = bookRepository.findById(book.getId());
        assertTrue(retrievedBook.isPresent());
        assertEquals("Test Book", retrievedBook.get().getName());

        Optional<Reader> retrievedReader = readerRepository.findById(reader.getId());
        assertTrue(retrievedReader.isPresent());
        assertEquals("Test Reader", retrievedReader.get().getName());

        Optional<Issue> retrievedIssue = issueRepository.findById(issue.getId());
        assertTrue(retrievedIssue.isPresent());
        assertEquals(book.getId(), retrievedIssue.get().getBookId());
        assertEquals(reader.getId(), retrievedIssue.get().getReaderId());

        // Проверка удаления
        issueRepository.delete(issue);
        assertFalse(issueRepository.existsById(issue.getId()));

        bookRepository.delete(book);
        assertFalse(bookRepository.existsById(book.getId()));

        readerRepository.delete(reader);
        assertFalse(readerRepository.existsById(reader.getId()));
    }
}