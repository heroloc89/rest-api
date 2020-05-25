package com.example.restapi.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMQController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/direct/producer")
    public String direct(@RequestParam("exchangeName") String exchange,
                           @RequestParam("routingKey") String routingKey,
                           @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Successfully";
    }

    @GetMapping(value = "/fanout/producer")
    public String fanout(@RequestParam("exchangeName") String exchange,
                           @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(exchange, messageData);

        return "Message sent to the RabbitMQ Fanout Exchange Successfully";
    }

    @GetMapping(value = "/topic/producer")
    public String topic(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
                           @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Topic Exchange Successfully";
    }


}
