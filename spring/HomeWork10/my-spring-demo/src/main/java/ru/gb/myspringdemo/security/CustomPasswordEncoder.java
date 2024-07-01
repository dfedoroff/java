package ru.gb.myspringdemo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Пользовательская реализация PasswordEncoder.
 * В данной реализации пароли не шифруются, что не рекомендуется для использования в продакшене.
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    /**
     * Кодирует пароль. В данной реализации возвращает пароль без изменений.
     * @param rawPassword исходный пароль
     * @return закодированный пароль (в данном случае - исходный пароль)
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return String.valueOf(rawPassword);
    }

    /**
     * Проверяет, соответствует ли введенный пароль закодированному.
     * @param rawPassword введенный пароль
     * @param encodedPassword закодированный пароль
     * @return true, если пароли совпадают, иначе false
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}