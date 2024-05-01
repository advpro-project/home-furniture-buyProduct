package com.hoomgroom.buyproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class BuyProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyProductApplication.class, args);
    }

}
