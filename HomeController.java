package com.suryansh.reactiveprogramming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {

    @GetMapping("/check")
    public Mono<String> check(){
//        return "<h1>I am Suryansh </h1>";
        return Mono.just("<h1>I am Suryansh </h1>");
    }

}
