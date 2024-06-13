package ru.gb.myspringdemo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.myspringdemo.service.BookService;

@Controller
public class BookUiController {

    @Autowired
    private BookService bookService;

    @GetMapping("/ui/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.showAllBooks());
        return "books";
    }
}
