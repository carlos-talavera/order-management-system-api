package com.charlie2code.userservice.application.command.createuser;

import com.charlie2code.userservice.application.exception.InvalidAuthIdException;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserCommand {
    private UUID authId;
    private String email;
    private String firstName;
    private String lastName;

    public CreateUserCommand(String authId, String email, String firstName, String lastName) {
        if (authId != null) {
            try {
                this.authId = UUID.fromString(authId);
            } catch(IllegalArgumentException ex) {
                throw new InvalidAuthIdException("Auth ID must be a valid UUID");
            }
        }

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
