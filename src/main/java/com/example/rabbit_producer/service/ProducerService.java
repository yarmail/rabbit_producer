package com.example.rabbit_producer.service;


import com.example.rabbit_producer.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("{spring.rabbitmq.exchange}")
    private String exchange;

    @Value("{spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
    }
}