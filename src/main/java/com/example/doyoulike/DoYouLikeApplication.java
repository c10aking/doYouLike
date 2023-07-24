package com.example.doyoulike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.doyoulike.member.entity")
public class DoYouLikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoYouLikeApplication.class, args);
    }

}
