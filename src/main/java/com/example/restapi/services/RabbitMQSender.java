package com.example.restapi.services;

import com.example.restapi.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${restapi.rabbitmq.exchange}")
    private String exchange;

    @Value("${restapi.rabbitmq.routingkey}")
    private String routingkey;

    public void send(EmployeeDTO employee) {
        amqpTemplate.convertAndSend(exchange, routingkey, employee);
        log.info("Send msg = " + employee);
    }
}
