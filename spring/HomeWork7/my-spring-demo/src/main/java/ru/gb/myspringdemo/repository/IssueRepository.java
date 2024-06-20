package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
