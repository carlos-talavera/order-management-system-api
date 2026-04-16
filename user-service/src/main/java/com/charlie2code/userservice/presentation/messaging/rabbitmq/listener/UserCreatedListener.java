package com.charlie2code.userservice.presentation.messaging.rabbitmq.listener;

import com.charlie2code.userservice.application.messaging.usercreated.UserCreatedConsumer;
import com.charlie2code.userservice.application.messaging.usercreated.UserCreatedInput;
import com.charlie2code.userservice.infrastructure.messaging.rabbitmq.config.RabbitMQConfig;
import com.charlie2code.userservice.infrastructure.messaging.rabbitmq.message.UserCreatedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedListener {

    private final UserCreatedConsumer userCreatedConsumer;

    @RabbitListener(queues = RabbitMQConfig.USER_EVENTS_QUEUE)
    public void handle(UserCreatedMessage message) {
        UserCreatedInput input = new UserCreatedInput(
            message.authId(),
            message.firstName(),
            message.lastName(),
            message.email()
        );

        userCreatedConsumer.handle(input);
    }
}

