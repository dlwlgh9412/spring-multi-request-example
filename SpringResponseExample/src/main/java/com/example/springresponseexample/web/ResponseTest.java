package com.example.springresponseexample.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResponseTest {
    private int RESPONSE_COUNT = 0;
    @GetMapping("/test/response")
    public ResponseEntity<?> response() {
        return new ResponseEntity<>(Integer.valueOf(++RESPONSE_COUNT), HttpStatus.OK);
    }
}
