package com.product.evaluate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EvaluateApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvaluateApplication.class, args);
    }

}
