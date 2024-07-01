package ru.gb.myspringdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Сущность, представляющая пользователя системы.
 * Используется для аутентификации и авторизации пользователей.
 */
@Entity
@Data
@Table(name = "users")
public class User {

    /** Уникальный идентификатор пользователя */
    @Id
    private Long id;

    /** Логин пользователя */
    @Column(name = "login")
    private String login;

    /** Пароль пользователя */
    @Column(name = "password")
    private String password;

    /** Роль пользователя в системе */
    @Column(name = "role")
    private String role;
}