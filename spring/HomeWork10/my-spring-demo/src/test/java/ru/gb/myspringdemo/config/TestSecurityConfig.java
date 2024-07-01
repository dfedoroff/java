package ru.gb.myspringdemo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурация безопасности для тестов.
 * Отключает большинство механизмов безопасности для упрощения тестирования.
 */
@TestConfiguration
@EnableWebSecurity
@Order(1)
public class TestSecurityConfig {

    /**
     * Настраивает цепочку фильтров безопасности для тестового окружения.
     * @param http объект для настройки безопасности HTTP
     * @return настроенную цепочку фильтров безопасности
     * @throws Exception если возникает ошибка при конфигурации
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Отключение CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll() // Разрешение всех запросов
                );
        return http.build();
    }
}