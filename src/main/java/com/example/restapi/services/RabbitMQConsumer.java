package com.example.restapi.services;

import com.example.restapi.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumer {
//    @RabbitListener(queues = "${restapi.rabbitmq.queue}")
//    public void recievedMessage(Employee employee) {
//        log.info("Recieved Message From RabbitMQ: " + employee);
//    }
}
