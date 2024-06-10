package ru.gb.myspringdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.myspringdemo.api.BookRequest;
import ru.gb.myspringdemo.api.ReaderRequest;
import ru.gb.myspringdemo.model.Book;
import ru.gb.myspringdemo.model.Reader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// Этот тест проверяет, что контекст приложения загружается без ошибок
	}

	@Test
	void testGetAllBooks() {
		ResponseEntity<List> response = restTemplate.getForEntity("/book", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	void testAddNewBook() {
		BookRequest newBook = new BookRequest();
		newBook.setName("Тестовая книга");
		ResponseEntity<Book> response = restTemplate.postForEntity("/book", newBook, Book.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo("Тестовая книга");
	}

	@Test
	void testGetAllReaders() {
		ResponseEntity<List> response = restTemplate.getForEntity("/reader", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	void testAddNewReader() {
		ReaderRequest newReader = new ReaderRequest();
		newReader.setName("Тестовый читатель");
		ResponseEntity<Reader> response = restTemplate.postForEntity("/reader", newReader, Reader.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo("Тестовый читатель");
	}
}
