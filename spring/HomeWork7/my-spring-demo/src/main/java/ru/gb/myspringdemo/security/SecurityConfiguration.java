package ru.gb.myspringdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/ui/issues/**").hasAuthority("admin")
                        .requestMatchers("/ui/readers/**").hasAuthority("reader")
                        .requestMatchers("/ui/books/**").authenticated()
                        .requestMatchers("/login", "/api/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/ui/books", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                );
        return httpSecurity.build();
    }
}
