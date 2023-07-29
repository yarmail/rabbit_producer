package com.example.rabbit_producer.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("{rabbitmq.exchange.name}")
    private String exchange;

    @Value("{rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
    rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}