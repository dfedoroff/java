package ru.gb.myspringdemo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.myspringdemo.model.User;
import ru.gb.myspringdemo.repository.UserRepository;

import java.util.List;

/**
 * Пользовательская реализация UserDetailsService для аутентификации.
 * Загружает пользовательские данные из базы данных.
 */
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    /**
     * Загружает пользовательские данные по имени пользователя.
     * @param username имя пользователя
     * @return объект UserDetails с информацией о пользователе
     * @throws UsernameNotFoundException если пользователь не найден
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}