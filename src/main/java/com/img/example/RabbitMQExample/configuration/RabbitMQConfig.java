package com.img.example.RabbitMQExample.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

import static com.img.example.RabbitMQExample.service.Util.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue Stream() {
        HashMap<String, Object> args = new HashMap();
        args.put("x-queue-type", "stream");
       // args.put("x-stream-offset", "next");
        args.put("x-message-ttl", 10000);
        Queue build = new Queue(STREAM, true, false, false, args);
        return build;
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE, true, false);
    }

    @Bean
    Binding paymentBinding() {
        return new Binding(STREAM, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, null);
    }


    @Bean
    public RabbitTemplate paymentRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        final Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        template.setMessageConverter(messageConverter);
        template.setExchange(EXCHANGE);
        return template;
    }


}