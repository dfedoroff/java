package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.service.ReportService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
//@Profile("prod")
public class SpringDemoApplication {

	// func()

	// Data Transfer Object
	// CLIENT(DTO) controller(DTO) | service(MODEL) repository(MODEL) DB(MODEL)

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
		context.getBean(ReportService.class).generateReport();

		InputStream in = Files.newInputStream(Path.of("file.txt"));
		Reader reader = new InputStreamReader(in);
	}

}
