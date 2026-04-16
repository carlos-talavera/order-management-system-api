package com.charlie2code.userservice.infrastructure.messaging.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String USER_EVENTS_EXCHANGE = "user.events";
    public static final String USER_EVENTS_QUEUE = "user-service.user-events";
    public static final String USER_CREATED_ROUTING_KEY = "user.created";

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public Queue userEventsQueue() {
        return QueueBuilder.durable(USER_EVENTS_QUEUE).build();
    }

    @Bean
    public TopicExchange userEventsExchange() {
        return ExchangeBuilder.topicExchange(USER_EVENTS_EXCHANGE).durable(true).build();
    }

    @Bean
    public Binding userCreatedBinding(Queue userEventsQueue, TopicExchange userEventsExchange) {
        return BindingBuilder
                .bind(userEventsQueue)
                .to(userEventsExchange)
                .with(USER_CREATED_ROUTING_KEY);
    }
}
