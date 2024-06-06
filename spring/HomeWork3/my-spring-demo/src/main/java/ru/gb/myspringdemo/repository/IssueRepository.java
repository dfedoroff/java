package ru.gb.myspringdemo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {

    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Issue getIssueById(long id) {
        return issues.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Issue> showIssueList() {
        return List.copyOf(issues);
    }

    public void checkIssueStatus(Issue newIssueStatus) {
        Issue oldIssueStatus = issues.stream()
                .filter(it -> Objects.equals(it.getId(), newIssueStatus.getId()))
                .findFirst()
                .orElse(null);
        if (oldIssueStatus != null) {
            int index = issues.indexOf(oldIssueStatus);
            issues.set(index, newIssueStatus);
        }
    }

    public void deleteIssue(Issue issue) {
        issues.remove(issue);
    }
}
