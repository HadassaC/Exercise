package com.exercise.exercise.controller;

import com.exercise.exercise.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("domain")
public class WebhookController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/{queueName}")
    public String handleMessage(@PathVariable String queueName, @RequestBody String message) {
        producerService.handleMassage(queueName, message);
        return "success";
    }

}
