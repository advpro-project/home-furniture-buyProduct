package com.hoomgroom.buyproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @GetMapping("/hi")
    public String index() {
        return "Hi from buy-Product Service!";
    }

}
