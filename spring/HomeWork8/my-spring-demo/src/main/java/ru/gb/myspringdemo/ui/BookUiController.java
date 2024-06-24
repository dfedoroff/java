package ru.gb.myspringdemo.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.service.BookService;
import ru.gb.myspringdemo.aspect.Timer;

@Controller
@Tag(name = "Book UI")
public class BookUiController {

    @Autowired
    private BookService bookService;

    @GetMapping("/ui/books")
    @Operation(summary = "get list of all books", description = "Загружает страницу со списком книг, внесённых в систему")
    @Timer
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.showAllBooks());
        model.addAttribute("newBook", new BookRequest());
        return "books";
    }
}
