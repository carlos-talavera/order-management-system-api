package com.charlie2code.userservice.domain.valueobject;

import com.charlie2code.userservice.domain.exception.InvalidUserIdException;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
public final class UserId {
    private final UUID value;

    private UserId(UUID value) {
        if (value == null) {
            throw new InvalidUserIdException(null);
        }
        this.value = value;
    }

    public static UserId of(UUID value) {
        return new UserId(value);
    }

    public static UserId from(String value) {
        try {
            return new UserId(UUID.fromString(value));
        } catch (IllegalArgumentException ex) {
            throw new InvalidUserIdException(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId other)) return false;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
