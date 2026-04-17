package com.charlie2code.userservice.application.messaging.usercreated;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.mapper.createuser.CreateUserMapper;
import com.charlie2code.userservice.application.usecase.CreateUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserCreatedConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserCreatedConsumer.class);
    private final CreateUserUseCase createUserUseCase;

    public UserCreatedConsumer(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public void handle(UserCreatedInput input) {
        log.info("Handling UserCreatedMessage for authId={}", input.authId());

        CreateUserCommand command = CreateUserMapper.toCommand(input);

        createUserUseCase.execute(command);
    }
}
