package com.img.example.RabbitMQExample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        msg += "_" + LocalDateTime.now();
        logger.info("Sending the messages to RabbitMQ: {}", msg);
        rabbitTemplate.convertAndSend(msg);
//        final ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("rabbitmq");
//        try (Connection connection = factory.newConnection()) {
//            final Channel channel = connection.createChannel();
//            channel.exchangeDeclare(Util.EXCHANGE, BuiltinExchangeType.FANOUT);
//            channel.basicPublish(Util.EXCHANGE, Util.ROUTING_KEY, null, msg.getBytes());
//        } catch (TimeoutException | IOException e) {
//            logger.error("Exception: {}", e.getMessage());
//        }
    }
}
