package com.miniproject;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-no-di")
public class ApiNoDi {
    private Lion lion;
    private Bird bird;

    public ApiNoDi() {
        this.lion = new Lion();
        this.bird = new Bird();
    }

    @GetMapping(value = "/animal")
    public ResponseEntity<Object> getAnimalNoise() {
        String noise;
        Optional<String> animalEnv = Optional.ofNullable(System.getenv("ANIMAL"));
        switch (animalEnv.isPresent() ? animalEnv.get() : "default") {
            case "com.miniproject.Bird":
                noise = this.bird.makeNoise();
                break;
            case "com.miniproject.Lion":
                noise = this.lion.makeNoise();
                break;
            default:
                noise = this.bird.makeNoise();
        }
        return ResponseEntity.ok().body(new ApiResponse(noise));
    }

}