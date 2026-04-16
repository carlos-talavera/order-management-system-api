package com.charlie2code.userservice.application.mapper.createuser;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.dto.createuser.CreateUserRequest;
import com.charlie2code.userservice.application.messaging.usercreated.UserCreatedInput;
import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.valueobject.Email;
import com.charlie2code.userservice.domain.valueobject.UserId;

import java.util.UUID;

public class CreateUserMapper {

    private CreateUserMapper() {}

    public static CreateUserCommand toCommand(CreateUserRequest request) {
        return new CreateUserCommand(
            request.authId(),
            request.email(),
            request.firstName(),
            request.lastName()
        );
    }

    public static CreateUserCommand toCommand(UserCreatedInput input) {
        return new CreateUserCommand(
            input.getAuthId(),
            input.getEmail(),
            input.getFirstName(),
            input.getLastName()
        );
    }

    public static User toDomain(CreateUserCommand command) {
        return User.create(
            UserId.of(UUID.randomUUID()),
            command.getAuthId(),
            Email.of(command.getEmail()),
            command.getFirstName(),
            command.getLastName()
        );
    }
}
