package com.img.example.RabbitMQExample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.img.example.RabbitMQExample.service.Util.STREAM;

@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

//    @RabbitListener(queues = STREAM)
    public void receiveMessage(Message delivery) {
        logger.info("start listening ...");
        try {
//            AMQP.Queue.DeclareOk declareOk = channel.queueDeclare();
//            String queueName = declareOk.getQueue();
//            logger.info("listening on queue name: {}", queueName);
//
//            int msgCount = declareOk.getMessageCount();
//            int conCount = declareOk.getConsumerCount();
//            logger.info("Message count: {}, Consumer count: {}", msgCount, conCount);
//
//            channel.queueBind(queueName, Util.EXCHANGE, Util.ROUTING_KEY);
            String message = new String(delivery.getBody(), "UTF-8");
            logger.info("Received '{}'", message);
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String message = new String(delivery.getBody(), "UTF-8");
//                logger.info("Received '{}'", message);
//            };
//            channel.basicConsume(queueName, false, deliverCallback, consumerTag -> {
//            });
//            channel.basicConsume(queueName, true, ((tag, msg) -> {
//                        logger.info("Receiving the messages from RabbitMQ: {}", new String(msg.getBody(), StandardCharsets.UTF_8));
//                    }),
//                    (tag, sig) -> {
//                        logger.error(sig.getMessage());
//                    });
            logger.info("Listening done");
        } catch (Exception e) {
            logger.error("Exception: {}", e.getMessage());
        }
    }
}
