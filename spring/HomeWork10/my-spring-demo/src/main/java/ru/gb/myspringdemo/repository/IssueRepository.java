package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Issue;

/**
 * Репозиторий для работы с сущностью Issue.
 * Предоставляет методы для выполнения CRUD операций с выдачами книг.
 */
@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}