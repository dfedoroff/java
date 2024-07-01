package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.IssueRequest;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.repository.BookRepository;
import ru.gb.myspringdemo.repository.IssueRepository;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Сервис для управления выдачами книг.
 * Реализует бизнес-логику работы с выдачами.
 */
@Service
@RequiredArgsConstructor
public class IssueService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Value("${application.max-allowed-books:1}")
    private long booksLimit;

    /**
     * Создает новую выдачу книги.
     * @param request запрос на выдачу книги
     * @return информация о выдаче
     * @throws NoSuchElementException если книга или читатель не найдены
     * @throws RuntimeException если превышен лимит книг на руках у читателя
     */
    public Issue issue(IssueRequest request) {
        long bookId = request.getBookId();
        long readerId = request.getReaderId();
        bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Не найдена книга с идентификатором \"" + bookId + "\""));
        readerRepository.findById(readerId)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с идентификатором \"" + readerId + "\""));

        long activeIssues = issueRepository.findAll().stream()
                .filter(it -> it.getReaderId() == readerId)
                .filter(it -> it.getReturned_at() == null)
                .count();

        if (activeIssues >= booksLimit) {
            throw new RuntimeException("Максимально разрешенное количество книг на руках у читателя с id: \"" + readerId + "\"");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        return issueRepository.save(issue);
    }

    /**
     * Получает информацию о выдаче по её ID.
     * @param id идентификатор выдачи
     * @return информация о выдаче
     * @throws NoSuchElementException если выдача не найдена
     */
    public Issue showIssueInfo(long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найдена выдача книг с id: \"" + id + "\""));
    }

    /**
     * Получает все выдачи для конкретного читателя.
     * @param id идентификатор читателя
     * @return список выдач
     * @throws NoSuchElementException если читатель не найден или у него нет выдач
     */
    public List<Issue> getAllIssuesByReader(long id) {
        readerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с id: \"" + id + "\""));
        List<Issue> allIssuesList = issueRepository.findAll().stream()
                .filter(it -> it.getReaderId() == id)
                .toList();
        if (allIssuesList.isEmpty()) {
            throw new NoSuchElementException("Не найдены выдачи книг читателю с id: \"" + id + "\"");
        }
        return allIssuesList;
    }

    /**
     * Регистрирует возврат книги.
     * @param id идентификатор выдачи
     * @return обновленная информация о выдаче
     * @throws NoSuchElementException если выдача не найдена
     */
    public Issue returnBook(long id) {
        Issue issue = showIssueInfo(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена выдача id: \"" + id + "\"");
        }
        issue.setReturned_at(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    /**
     * Получает список всех выдач.
     * @return список всех выдач
     */
    public List<Issue> showAllIssues() {
        return issueRepository.findAll();
    }
}