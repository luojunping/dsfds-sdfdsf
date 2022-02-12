package com.ljp.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping("/hello/")
@RestController
@Slf4j
public class HelloController {

    @GetMapping("world")
    public String helloWorld() {
        log.error("hello world !!!");
        
        new Thread(() -> log.error("hello world !!!")).start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> log.error("hello world !!!"));
        executorService.shutdown();
        return "hello world !!!";
    }

    @GetMapping("china")
    public String helloChina() {
        log.error("hello china !!!");
        return "hello china !!!";
    }

    @GetMapping("any")
    public String helloAny(@RequestParam("any") String any) {
        log.error("hello " + any + " !!!");
        return "hello " + any + " !!!";
    }

}
