package com.example.rabbit_producer.controller;

import com.example.rabbit_producer.domain.User;
import com.example.rabbit_producer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class ProducerController {

    private final ProducerService producerService;
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Value("${app.message}")
    private String response;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        producerService.sendMessage(user);
        logger.info("---------------");
        logger.info("user sent: " + user);
        logger.info("---------------");
        return ResponseEntity.ok(response);
    }
}
