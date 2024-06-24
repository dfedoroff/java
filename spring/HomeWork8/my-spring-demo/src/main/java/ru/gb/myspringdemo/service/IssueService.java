package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.IssueRequest;
import ru.gb.myspringdemo.aspect.RecoverException;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.repository.BookRepository;
import ru.gb.myspringdemo.repository.IssueRepository;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Value("${application.max-allowed-books:1}")
    private long booksLimit;

    @Timer
    @RecoverException(noRecoverFor = {RuntimeException.class})
    public Issue issue(IssueRequest request) {
        long bookId = request.getBookId();
        long readerId = request.getReaderId();
        bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Не найдена книга с идентификатором \"" + bookId + "\""));
        readerRepository.findById(readerId)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с идентификатором \"" + readerId + "\""));

        long readerIssuedBooksAmount = issueRepository.findAll().stream()
                .filter(it -> it.getReaderId() == readerId)
                .filter(it -> it.getIssued_at() != null)
                .count();
        long readerReturnedBooksAmount = issueRepository.findAll().stream()
                .filter(it -> it.getReaderId() == readerId)
                .filter(it -> it.getReturned_at() != null)
                .count();

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        if (readerIssuedBooksAmount - readerReturnedBooksAmount < booksLimit) {
            issueRepository.save(issue);
        } else {
            issueRepository.delete(issue);
            Issue.sequence--;
            throw new RuntimeException("Максимально разрешенное количество книг на руках у читателя с id: \"" + readerId + "\"");
        }
        return issue;
    }

    @Timer
    public Issue showIssueInfo(long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найдена выдача книг с id: \"" + id + "\""));
    }

    @Timer
    @RecoverException(noRecoverFor = {NoSuchElementException.class})
    public Issue returnBook(long id) {
        Issue issue = showIssueInfo(id);
        issue.setReturned_at(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    @Timer
    public List<Issue> showAllIssues() {
        return issueRepository.findAll();
    }

    @Timer
    public List<Issue> getAllIssuesByReader(long readerId) {
        return issueRepository.findAll().stream()
                .filter(issue -> issue.getReaderId() == readerId)
                .collect(Collectors.toList());
    }
}
