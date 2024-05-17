package com.hoomgroom.buyproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BuyProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyProductApplication.class, args);

    }

}
