package ru.gb.myspringdemo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.service.ReaderService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReaderControllerTest {

    @Mock
    private ReaderService readerService;

    @Mock
    private IssueService issueService;

    @InjectMocks
    private ReaderController readerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllReaders() {
        List<Reader> readers = Arrays.asList(new Reader("Читатель1"), new Reader("Читатель2"));
        when(readerService.showAllReaders()).thenReturn(readers);

        ResponseEntity<List<Reader>> response = readerController.getAllReaders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(readers, response.getBody());
    }

    @Test
    void getReaderInfo() {
        Reader reader = new Reader("Тестовый читатель");
        when(readerService.showReaderInfo(1L)).thenReturn(reader);

        ResponseEntity<Reader> response = readerController.getReaderInfo(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reader, response.getBody());
    }

    @Test
    void getReaderInfoNotFound() {
        when(readerService.showReaderInfo(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Reader> response = readerController.getReaderInfo(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void deleteReader() {
        Reader reader = new Reader("Читатель для удаления");
        when(readerService.deleteReader(1L)).thenReturn(reader);

        ResponseEntity<Reader> response = readerController.deleteReader(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reader, response.getBody());
    }

    @Test
    void deleteReaderNotFound() {
        when(readerService.deleteReader(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Reader> response = readerController.deleteReader(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void addNewReader() {
        ReaderRequest request = new ReaderRequest();
        request.setName("Новый читатель");
        Reader newReader = new Reader("Новый читатель");
        when(readerService.addNewReader(request)).thenReturn(newReader);

        ResponseEntity<Reader> response = readerController.addNewReader(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newReader, response.getBody());
    }

    @Test
    void addNewReaderConflict() {
        ReaderRequest request = new ReaderRequest();
        request.setName("Существующий читатель");
        when(readerService.addNewReader(request)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Reader> response = readerController.addNewReader(request);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void getReaderIssues() {
        List<Issue> issues = Arrays.asList(new Issue(1L, 1L), new Issue(2L, 1L));
        when(issueService.getAllIssuesByReader(1L)).thenReturn(issues);

        ResponseEntity<List<Issue>> response = readerController.getReaderIssues(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(issues, response.getBody());
    }

    @Test
    void getReaderIssuesNotFound() {
        when(issueService.getAllIssuesByReader(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<List<Issue>> response = readerController.getReaderIssues(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}