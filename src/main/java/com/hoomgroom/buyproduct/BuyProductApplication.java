package com.hoomgroom.buyproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication()
@EnableAsync
public class BuyProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyProductApplication.class, args);

    }

}
