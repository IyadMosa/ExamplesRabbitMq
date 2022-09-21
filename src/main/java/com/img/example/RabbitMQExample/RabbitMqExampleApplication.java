package com.img.example.RabbitMQExample;

import com.img.example.RabbitMQExample.service.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RabbitMqExampleApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RabbitMqExampleApplication.class, args);
//        Consumer consumer = context.getBean(Consumer.class);
//        consumer.receiveMessage();
    }

}
