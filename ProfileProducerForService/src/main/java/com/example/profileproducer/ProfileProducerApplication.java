package com.example.profileproducer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class ProfileProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileProducerApplication.class, args);
    }

}
