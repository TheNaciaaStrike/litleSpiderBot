package com.thenaciaastrike.litlespiderbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LitleSpiderBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(LitleSpiderBotApplication.class, args);
    }
    @GetMapping("/")
    public String hello() {
        return String.format("Hello!");
    }

}
