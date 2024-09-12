package com.chrslex.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
/**
 * RestController
 */
public class ControllerRest {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Worl!";
    }
}