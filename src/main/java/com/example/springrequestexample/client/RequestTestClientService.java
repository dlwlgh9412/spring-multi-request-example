package com.example.springrequestexample.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Slf4j
@Component
public class RequestTestClientService {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8081")
            .build();

    public void printResponse(int count) {
        Flux.range(0, count)
                .parallel(count)
                .runOn(Schedulers.newParallel("REQUEST", count))
                .flatMap(val -> getResponse())
                .subscribe(result -> log.info("respone: {}", result));
    }
    private Mono<Integer> getResponse() {
        return webClient.get()
                .uri("/test/response")
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(Integer.class);
    }

}
