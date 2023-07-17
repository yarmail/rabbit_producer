package com.example.rabbit_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
        System.out.println("------------------------------");
        System.out.println("Проект rabbit_producer запущен");
        System.out.println("------------------------------");
    }
}