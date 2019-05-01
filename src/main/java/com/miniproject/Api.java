package com.miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Api {

    @Autowired
    private Animal animal;

    @GetMapping
    public ResponseEntity<Object> getHello() {
        return ResponseEntity.ok().body(new ApiResponse("Hello world!"));
    }

    @GetMapping(value = "/animal")
    public ResponseEntity<Object> getAnimalNoise() {
        String animalNoise = animal.makeNoise();
        return ResponseEntity.ok().body(new ApiResponse(animalNoise));
    }

}