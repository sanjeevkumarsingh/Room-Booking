package com.coding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class WelcomeController {
    @GetMapping(value = "/welcome")
    public String welcome(){
        return "Welcome ";
    }
}
