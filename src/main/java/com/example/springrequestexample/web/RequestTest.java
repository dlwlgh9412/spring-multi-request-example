package com.example.springrequestexample.web;

import com.example.springrequestexample.client.RequestTestClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RequestTest {
    private final RequestTestClientService service;

    @GetMapping("/test/request")
    public String test(@RequestParam("count") int count) {
        service.printResponse(count);
        return "Request Complete";
    }
}
