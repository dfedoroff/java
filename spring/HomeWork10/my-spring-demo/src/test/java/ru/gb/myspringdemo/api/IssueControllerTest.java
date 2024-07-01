package ru.gb.myspringdemo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.service.IssueService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IssueControllerTest {

    @Mock
    private IssueService issueService;

    @InjectMocks
    private IssueController issueController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void issueBook() {
        IssueRequest request = new IssueRequest();
        request.setReaderId(1L);
        request.setBookId(1L);
        Issue newIssue = new Issue(1L, 1L);
        when(issueService.issue(request)).thenReturn(newIssue);

        ResponseEntity<Issue> response = issueController.issueBook(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newIssue, response.getBody());
    }

    @Test
    void issueBookNotFound() {
        IssueRequest request = new IssueRequest();
        when(issueService.issue(request)).thenThrow(new NoSuchElementException());

        ResponseEntity<Issue> response = issueController.issueBook(request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void issueBookConflict() {
        IssueRequest request = new IssueRequest();
        when(issueService.issue(request)).thenThrow(new RuntimeException());

        ResponseEntity<Issue> response = issueController.issueBook(request);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void getIssueInfo() {
        Issue issue = new Issue(1L, 1L);
        when(issueService.showIssueInfo(1L)).thenReturn(issue);

        ResponseEntity<Issue> response = issueController.getIssueInfo(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(issue, response.getBody());
    }

    @Test
    void getIssueInfoNotFound() {
        when(issueService.showIssueInfo(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Issue> response = issueController.getIssueInfo(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllIssues() {
        List<Issue> issues = Arrays.asList(new Issue(1L, 1L), new Issue(2L, 2L));
        when(issueService.showAllIssues()).thenReturn(issues);

        ResponseEntity<List<Issue>> response = issueController.getAllIssues();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(issues, response.getBody());
    }

    @Test
    void returnBook() {
        Issue returnedIssue = new Issue(1L, 1L);
        returnedIssue.setReturned_at(java.time.LocalDateTime.now());
        when(issueService.returnBook(1L)).thenReturn(returnedIssue);

        ResponseEntity<Issue> response = issueController.returnBook(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(returnedIssue, response.getBody());
    }

    @Test
    void returnBookNotFound() {
        when(issueService.returnBook(1L)).thenThrow(new NoSuchElementException());

        ResponseEntity<Issue> response = issueController.returnBook(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}