package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.User;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностью User.
 * Предоставляет методы для выполнения CRUD операций с пользователями.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Находит пользователя по его логину.
     * @param login логин пользователя
     * @return Optional, содержащий пользователя, если он найден, или пустой Optional, если пользователь не найден
     */
    Optional<User> findByLogin(String login);
}