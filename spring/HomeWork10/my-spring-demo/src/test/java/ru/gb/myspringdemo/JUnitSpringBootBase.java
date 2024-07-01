package ru.gb.myspringdemo;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.myspringdemo.config.TestSecurityConfig;

@ActiveProfiles("test")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {Application.class, TestSecurityConfig.class}
)
@AutoConfigureWebTestClient
public class JUnitSpringBootBase {
}