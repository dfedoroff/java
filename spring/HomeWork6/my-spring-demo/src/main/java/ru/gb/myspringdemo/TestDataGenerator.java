package ru.gb.myspringdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.BookRepository;
import ru.gb.myspringdemo.repository.IssueRepository;
import ru.gb.myspringdemo.repository.ReaderRepository;

@Component
public class TestDataGenerator {

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public TestDataGenerator(BookRepository bookRepository, IssueRepository issueRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        this.readerRepository = readerRepository;
    }

    @PostConstruct
    public void generateData() {
        bookRepository.save(new Book("Война и мир"));
        bookRepository.save(new Book("Мертвые души"));
        bookRepository.save(new Book("Хождение по мукам"));
        bookRepository.save(new Book("Записки охотника"));
        bookRepository.save(new Book("Двенадцать стульев"));
        readerRepository.save(new Reader("Читатель1"));
        readerRepository.save(new Reader("Читатель2"));
        readerRepository.save(new Reader("Читатель3"));
        readerRepository.save(new Reader("Читатель4"));
        readerRepository.save(new Reader("Читатель5"));
        issueRepository.save(new Issue(1, 1));
        issueRepository.save(new Issue(3, 1));
        issueRepository.save(new Issue(2, 2));
        issueRepository.save(new Issue(4, 2));
        issueRepository.save(new Issue(5, 3));
        issueRepository.save(new Issue(3, 3));
        issueRepository.save(new Issue(4, 4));
        issueRepository.save(new Issue(2, 4));
        issueRepository.save(new Issue(3, 5));
        issueRepository.save(new Issue(1, 5));
    }
}
