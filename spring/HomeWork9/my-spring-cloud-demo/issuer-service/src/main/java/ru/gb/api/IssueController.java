package ru.gb.api;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.gb.BookProvider;
import ru.gb.ReaderProvider;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/issue")
public class IssueController {

    private final Faker faker;
    private final BookProvider bookProvider;
    private final ReaderProvider readerProvider;
    private final List<Issue> issues;

    public IssueController(BookProvider bookProvider, ReaderProvider readerProvider) {
        this.faker = new Faker();
        this.bookProvider = bookProvider;
        this.readerProvider = readerProvider;
        this.issues = new ArrayList<>();
        refreshData().subscribe();
    }

    @GetMapping
    public Flux<Issue> getAll() {
        return Flux.fromIterable(issues);
    }

    @GetMapping("/refresh")
    public Mono<List<Issue>> refresh() {
        return refreshData();
    }

    private Mono<List<Issue>> refreshData() {
        issues.clear();
        List<Mono<Issue>> issueMonos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Mono<Issue> issueMono = Mono.zip(
                    bookProvider.getRandomBook(),
                    readerProvider.getRandomReader(),
                    (book, reader) -> {
                        Issue issue = new Issue();
                        issue.setId(UUID.randomUUID());
                        Date between = faker.date().between(startOfYear(), endOfYear());
                        issue.setIssuedAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        issue.setBook(book);
                        issue.setReader(reader);
                        return issue;
                    }
            );
            issueMonos.add(issueMono);
        }
        return Flux.merge(issueMonos)
                .collectList()
                .doOnNext(issues::addAll);
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.JANUARY);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }

    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }
}
