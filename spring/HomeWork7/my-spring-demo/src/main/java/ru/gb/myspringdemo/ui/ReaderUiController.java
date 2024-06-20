package ru.gb.myspringdemo.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Issue;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.service.BookService;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.service.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@Tag(name = "Reader UI")
public class ReaderUiController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private BookService bookService;

    @GetMapping("/ui/readers")
    @Operation(summary = "get list of all readers", description = "Загружает страницу со списком читателей, зарегистрированных в системе")
    public String showReaders(Model model) {
        model.addAttribute("readers", readerService.showAllReaders());
        return "readers";
    }

    @GetMapping("/ui/reader/{id}")
    @Operation(summary = "get issuance list by reader", description = "Загружает страницу со списком всех книг, когда-либо выданных читателю")
    public String showReaderInfo(@PathVariable long id, Model model) {
        try {
            Reader reader = readerService.showReaderInfo(id);
            List<Issue> issues = issueService.getAllIssuesByReader(id);
            List<Book> books = new ArrayList<>();
            for (Issue issue : issues) {
                books.add(bookService.showBookInfo(issue.getBookId()));
            }
            model.addAttribute("books", books);
            model.addAttribute("reader", reader);
            model.addAttribute("issues", issues);
            return "reader";
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}
