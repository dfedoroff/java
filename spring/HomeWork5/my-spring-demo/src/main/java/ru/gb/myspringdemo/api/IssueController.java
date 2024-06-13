package ru.gb.myspringdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService service;

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
        final Issue issue;
        try {
            issue = service.issue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueInfo(@PathVariable long id) {
        log.info("Получен запрос на описание факта выдачи: id = {}", id);
        final Issue issue;
        try {
            issue = service.showIssueInfo(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(issue);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues() {
        log.info("Получен запрос актуального списка всех выдач книг");
        return new ResponseEntity<>(service.showAllIssues(), HttpStatus.OK);
    }

    @PutMapping("/{issueId}")
    public ResponseEntity<Issue> returnBook(@PathVariable long issueId) {
        log.info("Получен запрос на возврат книги по выдаче с id = {}", issueId);
        final Issue issue;
        try {
            issue = service.returnBook(issueId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(issue);
    }
}
