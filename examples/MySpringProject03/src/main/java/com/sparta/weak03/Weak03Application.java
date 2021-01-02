package com.sparta.weak03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Weak03Application {

    public static void main(String[] args) {
        SpringApplication.run(Weak03Application.class, args);
    }

}
