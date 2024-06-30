package ru.gb;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.gb.api.Book;

import java.util.UUID;

@Service
public class BookProvider {

    private final WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public Mono<UUID> getRandomBookId() {
        return webClient.get()
                .uri("http://book-service/api/book/random")
                .retrieve()
                .bodyToMono(Book.class)
                .map(Book::getId);
    }

    public Mono<Book> getRandomBook() {
        return webClient.get()
                .uri("http://book-service/api/book/random")
                .retrieve()
                .bodyToMono(Book.class);
    }
}
