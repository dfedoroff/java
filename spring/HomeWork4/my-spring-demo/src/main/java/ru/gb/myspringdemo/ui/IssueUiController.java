package ru.gb.myspringdemo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.myspringdemo.service.IssueService;

@Controller
public class IssueUiController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/ui/issues")
    public String showIssues(Model model) {
        model.addAttribute("issues", issueService.showAllIssues());
        return "issues";
    }
}
