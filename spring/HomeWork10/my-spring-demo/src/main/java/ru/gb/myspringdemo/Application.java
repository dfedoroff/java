package ru.gb.myspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения Spring Boot.
 * @SpringBootApplication объединяет в себе @Configuration, @EnableAutoConfiguration и @ComponentScan
 */
@SpringBootApplication
public class Application {

	/**
	 * Точка входа в приложение.
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}