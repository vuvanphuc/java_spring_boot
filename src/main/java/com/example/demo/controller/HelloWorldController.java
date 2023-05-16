package com.example.demo.controller;

import com.example.demo.models.HelloWorld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class HelloWorldController {
    @RequestMapping("/HelloWorld")
    HelloWorld firstApi() {
        return new HelloWorld("HelloWorld");
    }
}
