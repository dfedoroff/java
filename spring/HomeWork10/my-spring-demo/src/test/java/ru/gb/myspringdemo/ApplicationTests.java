package ru.gb.myspringdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
		// Проверяем, что контекст приложения успешно загружается
		assertNotNull(context, "Контекст приложения не должен быть null");
	}

	@Test
	void mainMethodStartsApplication() {
		// Проверяем, что метод main не вызывает исключений при запуске
		Application.main(new String[]{});
	}
}