package ru.gb.myspringdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * REST-контроллер для управления выдачами книг.
 */
@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Issuance")
public class IssueController {

    @Autowired
    private IssueService service;

    /**
     * Регистрирует выдачу книги.
     * @param request запрос на выдачу книги
     * @return ResponseEntity с информацией о выдаче или ошибкой
     */
    @PostMapping
    @Operation(summary = "issue book", description = "Регистрирует выдачу книги читателю")
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

        try {
            Issue issue = service.issue(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(issue);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    /**
     * Получает информацию о конкретной выдаче.
     * @param id идентификатор выдачи
     * @return ResponseEntity с информацией о выдаче или ошибкой
     */
    @Timer
    @GetMapping("/{id}")
    @Operation(summary = "get issuance information", description = "Загружает информацию о конкретной выдаче книги читателю")
    public ResponseEntity<Issue> getIssueInfo(@PathVariable long id) {
        log.info("Получен запрос на описание факта выдачи: id = {}", id);

        try {
            Issue issue = service.showIssueInfo(id);
            return ResponseEntity.status(HttpStatus.OK).body(issue);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Получает информацию о всех выдачах.
     * @return ResponseEntity со списком всех выдач
     */
    @Timer
    @GetMapping
    @Operation(summary = "get information about all book issues", description = "Загружает информацию о всех выдачах книг читателям")
    public ResponseEntity<List<Issue>> getAllIssues() {
        log.info("Получен запрос актуального списка всех выдач книг");
        return new ResponseEntity<>(service.showAllIssues(), HttpStatus.OK);
    }

    /**
     * Регистрирует возврат книги.
     * @param issueId идентификатор выдачи
     * @return ResponseEntity с обновленной информацией о выдаче или ошибкой
     */
    @PutMapping("/{issueId}")
    @Operation(summary = "return book", description = "Регистрирует возврат книги читателем")
    public ResponseEntity<Issue> returnBook(@PathVariable long issueId) {
        log.info("Получен запрос на возврат книги по выдаче с id = {}", issueId);

        try {
            Issue issue = service.returnBook(issueId);
            return ResponseEntity.status(HttpStatus.OK).body(issue);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}