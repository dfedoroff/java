package ru.gb.myspringdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.aspect.RecoverException;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Issuance")
public class IssueController {

    @Autowired
    private IssueService service;

    @PostMapping
    @Operation(summary = "issue book", description = "Регистрирует выдачу книги читателю")
    @Timer
    @RecoverException(noRecoverFor = {RuntimeException.class})
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
    @Operation(summary = "get issuance information", description = "Загружает информацию о конкретной выдаче книги читателю")
    @Timer
    @RecoverException(noRecoverFor = {NoSuchElementException.class})
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

    @GetMapping
    @Operation(summary = "get information about all book issues", description = "Загружает информацию о всех выдачах книг читателям")
    @Timer
    public ResponseEntity<List<Issue>> getAllIssues() {
        log.info("Получен запрос актуального списка всех выдач книг");
        return new ResponseEntity<>(service.showAllIssues(), HttpStatus.OK);
    }

    @PutMapping("/{issueId}")
    @Operation(summary = "return book", description = "Регистрирует возврат книги читателем")
    @Timer
    @RecoverException(noRecoverFor = {NoSuchElementException.class})
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
