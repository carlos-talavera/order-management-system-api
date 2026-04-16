package com.charlie2code.userservice.application.messaging.usercreated;

import lombok.Data;

@Data
public class UserCreatedInput {
    private final String authId;
    private final String email;
    private final String firstName;
    private final String lastName;

    public UserCreatedInput(String authId, String email, String firstName, String lastName) {
        this.authId = authId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
