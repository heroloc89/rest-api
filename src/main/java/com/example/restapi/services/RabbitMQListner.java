package com.example.restapi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@Slf4j
public class RabbitMQListner implements MessageListener {
    @Override
    public void onMessage(Message message) {
        log.info("Consuming Message - " + new String(message.getBody()));
    }
}
