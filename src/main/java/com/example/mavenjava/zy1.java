package com.example.mavenjava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class zy1 {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello spring boot!!!!!";
    }
}
