package ru.gb;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.gb.api.Reader;

@Service
public class ReaderProvider {

    private final WebClient.Builder webClientBuilder;

    public ReaderProvider(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Reader> getRandomReader() {
        return webClientBuilder.build()
                .get()
                .uri("http://reader-service/api/reader/random")
                .retrieve()
                .bodyToMono(Reader.class);
    }
}
