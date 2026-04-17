package com.charlie2code.userservice.domain.entity;

import com.charlie2code.userservice.domain.exception.InvalidUserException;
import com.charlie2code.userservice.domain.valueobject.Email;
import com.charlie2code.userservice.domain.valueobject.UserId;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public final class User {
    private final UserId id;
    private final UUID authId;
    private final Email email;
    private final String firstName;
    private final String lastName;
    private final Instant createdAt;
    private final Instant updatedAt;

    private User(UserId id, UUID authId, Email email, String firstName, String lastName, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.authId = authId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(UserId id, UUID authId, Email email, String firstName, String lastName) {
        if (id == null || authId == null || email == null || firstName == null || lastName == null) {
            throw new InvalidUserException("All user fields must be provided");
        }

        if (firstName.isBlank() || lastName.isBlank()) {
            throw new InvalidUserException("User first name and last name cannot be empty");
        }

        Instant now = Instant.now();

        return new User(
            id,
            authId,
            email,
            firstName,
            lastName,
            now,
            now
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
