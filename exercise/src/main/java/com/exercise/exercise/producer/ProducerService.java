package com.exercise.exercise.producer;

import com.exercise.exercise.configuration.RabbitMQConfiguration;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;

    public void handleMassage(String queueName, String message) {
        try {
            rabbitTemplate.convertAndSend(queueName, message);
        }
        // AmqpException throwing when queue_name not exists
        catch (AmqpException ex) {
            System.out.println("message queue not exists" + ex);
            throw ex;
        }
    }
}
