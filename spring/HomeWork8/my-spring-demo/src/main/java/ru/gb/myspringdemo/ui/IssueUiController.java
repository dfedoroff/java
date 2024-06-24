package ru.gb.myspringdemo.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.myspringdemo.service.IssueService;
import ru.gb.myspringdemo.aspect.Timer;

@Controller
@Tag(name = "Issue UI")
public class IssueUiController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/ui/issues")
    @Operation(summary = "get table about all book issuance's", description = "Загружает страницу с таблицей с информацией о всех выдачах книг читателям")
    @Timer
    public String showIssues(Model model) {
        model.addAttribute("issues", issueService.showAllIssues());
        return "issues";
    }
}
