package ru.gb.myspringdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурация безопасности приложения.
 * Определяет правила доступа и настройки аутентификации.
 */
@Configuration
public class SecurityConfiguration {

    /**
     * Настраивает цепочку фильтров безопасности.
     * @param httpSecurity объект конфигурации HttpSecurity
     * @return настроенная цепочка фильтров безопасности
     * @throws Exception в случае ошибки конфигурации
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/ui/issues/**").hasAuthority("admin")
                        .requestMatchers("/ui/readers/**").hasAuthority("reader")
                        .requestMatchers("/ui/books/**").authenticated()
                        .requestMatchers("/ui/**").permitAll()
                        .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .build();
    }
}