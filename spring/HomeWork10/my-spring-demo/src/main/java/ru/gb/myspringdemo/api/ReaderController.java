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
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * REST-контроллер для управления читателями.
 * Обрабатывает HTTP-запросы, связанные с операциями над читателями.
 */
@Slf4j
@RestController
@RequestMapping("/reader")
@Tag(name = "Reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;
    @Autowired
    private IssueService issueService;

    /**
     * Получает список всех читателей.
     * @return ResponseEntity со списком всех читателей
     */
    @Timer
    @GetMapping()
    @Operation(summary = "get all readers", description = "Загружает список читателей, зарегистрированных в системе")
    public ResponseEntity<List<Reader>> getAllReaders() {
        log.info("Получен запрос актуального списка читателей");
        return new ResponseEntity<>(readerService.showAllReaders(), HttpStatus.OK);
    }

    /**
     * Получает информацию о конкретном читателе по его ID.
     * @param id идентификатор читателя
     * @return ResponseEntity с информацией о читателе или сообщением об ошибке
     */
    @Timer
    @GetMapping("/{id}")
    @Operation(summary = "get info about reader", description = "Загружает информацию о запрашиваемом читателе")
    public ResponseEntity<Reader> getReaderInfo(@PathVariable long id) {
        log.info("Получен запрос информации о читателе: Id = {}", id);
        try {
            Reader reader = readerService.showReaderInfo(id);
            return ResponseEntity.status(HttpStatus.OK).body(reader);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет читателя по его ID.
     * @param id идентификатор читателя
     * @return ResponseEntity с информацией об удаленном читателе или сообщением об ошибке
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "delete reader", description = "Удаляет читателя из системы по Id")
    public ResponseEntity<Reader> deleteReader(@PathVariable long id) {
        log.info("Получен запрос на удаление читателя: Id = {}", id);
        try {
            Reader reader = readerService.deleteReader(id);
            return ResponseEntity.status(HttpStatus.OK).body(reader);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Добавляет нового читателя в систему.
     * @param request запрос на добавление читателя
     * @return ResponseEntity с информацией о добавленном читателе или сообщением об ошибке
     */
    @PostMapping()
    @Operation(summary = "add new reader", description = "Добавляет нового читателя в систему")
    public ResponseEntity<Reader> addNewReader(@RequestBody ReaderRequest request) {
        log.info("Получен запрос на добавление читателя: name = {}", request.getName());
        try {
            Reader reader = readerService.addNewReader(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(reader);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    /**
     * Получает список всех выдач для конкретного читателя.
     * @param id идентификатор читателя
     * @return ResponseEntity со списком выдач или сообщением об ошибке
     */
    @Timer
    @GetMapping("/{id}/issue")
    @Operation(summary = "get all issuance by reader", description = "Загружает список выдач книг читателя")
    public ResponseEntity<List<Issue>> getReaderIssues(@PathVariable long id) {
        log.info("Получен запрос информации о выдачах читателя с id = {}", id);
        try {
            List<Issue> readersIssues = issueService.getAllIssuesByReader(id);
            return ResponseEntity.status(HttpStatus.OK).body(readersIssues);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}