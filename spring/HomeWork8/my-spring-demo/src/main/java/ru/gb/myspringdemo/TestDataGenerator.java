package ru.gb.myspringdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.gb.myspringdemo.model.*;
import ru.gb.myspringdemo.repository.*;
import ru.gb.myspringdemo.aspect.Timer;

@Component
public class TestDataGenerator {

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private static long id = 1L;

    public TestDataGenerator(BookRepository bookRepository, IssueRepository issueRepository, ReaderRepository readerRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        this.readerRepository = readerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Timer
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

    @PostConstruct
    @Timer
    public void generateUsers() {
        Role adminRole = new Role();
        adminRole.setName("admin");
        roleRepository.save(adminRole);

        Role readerRole = new Role();
        readerRole.setName("reader");
        roleRepository.save(readerRole);

        saveUser("admin", adminRole);
        saveUser("reader", readerRole);
    }

    private void saveUser(String login, Role role) {
        User user = new User();
        user.setId(id++);
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(login));
        user.addRole(role);
        userRepository.save(user);
    }
}
