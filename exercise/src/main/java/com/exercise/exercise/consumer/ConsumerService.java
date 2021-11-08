package com.exercise.exercise.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConsumerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitListener(queues = "#{RabbitMQConfiguration.getAllQueues()}")
    public void receivedMessage(String message) {
        System.out.println("Received Message From RabbitMQ: " + message);
    }

}
