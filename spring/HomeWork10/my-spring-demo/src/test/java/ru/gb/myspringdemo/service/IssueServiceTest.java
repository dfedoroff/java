package ru.gb.myspringdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import ru.gb.myspringdemo.api.IssueRequest;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.BookRepository;
import ru.gb.myspringdemo.repository.IssueRepository;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IssueServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ReaderRepository readerRepository;

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(issueService, "booksLimit", 2L);
    }

    @Test
    void testIssueSuccess() {
        IssueRequest request = new IssueRequest();
        request.setBookId(1L);
        request.setReaderId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(new Book("Test Book")));
        when(readerRepository.findById(1L)).thenReturn(Optional.of(new Reader("Test Reader")));
        when(issueRepository.findAll()).thenReturn(Collections.emptyList());
        when(issueRepository.save(any(Issue.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Issue result = issueService.issue(request);

        assertNotNull(result);
        assertEquals(1L, result.getBookId());
        assertEquals(1L, result.getReaderId());
    }

    @Test
    void testIssueExceedLimit() {
        IssueRequest request = new IssueRequest();
        request.setBookId(3L);
        request.setReaderId(1L);

        when(bookRepository.findById(3L)).thenReturn(Optional.of(new Book("Third Book")));
        when(readerRepository.findById(1L)).thenReturn(Optional.of(new Reader("Test Reader")));

        List<Issue> existingIssues = Arrays.asList(
                new Issue(1L, 1L),
                new Issue(2L, 1L)
        );
        when(issueRepository.findAll()).thenReturn(existingIssues);

        assertThrows(RuntimeException.class, () -> issueService.issue(request));
    }

    @Test
    void testIssueWithReturnedBooks() {
        IssueRequest request = new IssueRequest();
        request.setBookId(3L);
        request.setReaderId(1L);

        when(bookRepository.findById(3L)).thenReturn(Optional.of(new Book("Third Book")));
        when(readerRepository.findById(1L)).thenReturn(Optional.of(new Reader("Test Reader")));

        List<Issue> existingIssues = Arrays.asList(
                new Issue(1L, 1L),
                new Issue(2L, 1L)
        );
        existingIssues.get(0).setReturned_at(LocalDateTime.now()); // One book is returned
        when(issueRepository.findAll()).thenReturn(existingIssues);
        when(issueRepository.save(any(Issue.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Issue result = issueService.issue(request);

        assertNotNull(result);
        assertEquals(3L, result.getBookId());
        assertEquals(1L, result.getReaderId());
    }

    @Test
    void testShowIssueInfo() {
        Issue issue = new Issue(1L, 1L);
        when(issueRepository.findById(1L)).thenReturn(Optional.of(issue));

        Issue result = issueService.showIssueInfo(1L);

        assertEquals(1L, result.getBookId());
        assertEquals(1L, result.getReaderId());
    }

    @Test
    void testGetAllIssuesByReader() {
        when(readerRepository.findById(1L)).thenReturn(Optional.of(new Reader("Test Reader")));
        List<Issue> issues = Arrays.asList(new Issue(1L, 1L), new Issue(2L, 1L));
        when(issueRepository.findAll()).thenReturn(issues);

        List<Issue> result = issueService.getAllIssuesByReader(1L);

        assertEquals(2, result.size());
    }

    @Test
    void testReturnBook() {
        Issue issue = new Issue(1L, 1L);
        when(issueRepository.findById(1L)).thenReturn(Optional.of(issue));
        when(issueRepository.save(any(Issue.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Issue result = issueService.returnBook(1L);

        assertNotNull(result.getReturned_at());
    }

    @Test
    void testShowAllIssues() {
        List<Issue> issues = Arrays.asList(new Issue(1L, 1L), new Issue(2L, 2L));
        when(issueRepository.findAll()).thenReturn(issues);

        List<Issue> result = issueService.showAllIssues();

        assertEquals(2, result.size());
    }
}