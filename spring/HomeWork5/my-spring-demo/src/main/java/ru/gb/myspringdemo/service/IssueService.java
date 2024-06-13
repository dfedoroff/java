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

@Service
@RequiredArgsConstructor
public class IssueService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Value("${application.max-allowed-books:1}")
    private long booksLimit;

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

        Issue issue = new Issue(bookId, readerId);
        if (readerIssuedBooksAmount - readerReturnedBooksAmount < booksLimit) {
            issueRepository.save(issue);
        } else {
            throw new RuntimeException("Максимально разрешенное количество книг на руках у читателя с id: \"" + readerId + "\"");
        }
        return issue;
    }

    public Issue showIssueInfo(long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найдена выдача книг с id: \"" + id + "\""));
    }

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

    public Issue returnBook(long id) {
        Issue issue = showIssueInfo(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена выдача id: \"" + id + "\"");
        }
        issue.setReturned_at(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    public List<Issue> showAllIssues() {
        return issueRepository.findAll();
    }
}
