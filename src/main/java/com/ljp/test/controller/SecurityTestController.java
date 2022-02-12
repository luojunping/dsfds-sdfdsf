package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test/security/")
@RestController
public class SecurityTestController {

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("user")
    public String user() {
        return "user";
    }

}
