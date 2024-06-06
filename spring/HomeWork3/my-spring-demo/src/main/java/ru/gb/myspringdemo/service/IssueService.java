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
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }

        long readerBooksAmount = issueRepository.showIssueList().stream()
                .filter(it -> it.getReaderId() == request.getReaderId() && it.getReturned_at() == null)
                .count();

        if (readerBooksAmount >= booksLimit) {
            throw new RuntimeException("Максимально разрешенное количество книг на руках у читателя с id: \"" + request.getReaderId() + "\"");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue showIssueInfo(long id) {
        Issue issue = issueRepository.getIssueById(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена выдача книг с id: \"" + id + "\"");
        }
        return issue;
    }

    public List<Issue> getAllIssuesByReader(long id) {
        if (readerRepository.getReaderById(id) == null) {
            throw new NoSuchElementException("Не найден читатель с id: \"" + id + "\"");
        }

        List<Issue> allIssuesList = issueRepository.showIssueList().stream()
                .filter(it -> it.getReaderId() == id)
                .toList();
        if (allIssuesList.isEmpty()) {
            throw new NoSuchElementException("Не найдены выдачи книг читателю с id: \"" + id + "\"");
        }
        return allIssuesList;
    }

    public Issue returnBook(long id) {
        Issue issue = issueRepository.getIssueById(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена выдача id: \"" + id + "\"");
        }
        issue.setReturned_at(LocalDateTime.now());
        issueRepository.checkIssueStatus(issue);
        return issue;
    }

    public void deleteIssue(long id) {
        Issue issue = issueRepository.getIssueById(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена выдача id: \"" + id + "\"");
        }
        issueRepository.deleteIssue(issue);
    }

    public List<Issue> showAllIssues() {
        return issueRepository.showIssueList();
    }
}
