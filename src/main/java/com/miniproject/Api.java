package com.miniproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Api {

    @GetMapping
    public ResponseEntity<Object> getHello() {
        return ResponseEntity.ok().body(new ApiResponse("Hello world!"));
    }

}