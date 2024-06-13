package ru.gb.myspringdemo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.service.ReaderService;
import ru.gb.myspringdemo.service.IssueService;
import java.util.NoSuchElementException;

@Controller
public class ReaderUiController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private IssueService issueService;

    @GetMapping("/ui/readers")
    public String showReaders(Model model) {
        model.addAttribute("readers", readerService.showAllReaders());
        return "readers";
    }

    @GetMapping("/ui/reader/{id}")
    public String showReaderInfo(@PathVariable long id, Model model) {
        try {
            Reader reader = readerService.showReaderInfo(id);
            model.addAttribute("reader", reader);
            model.addAttribute("issues", issueService.getAllIssuesByReader(id));
            return "reader";
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}
