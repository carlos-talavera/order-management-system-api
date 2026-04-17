package com.charlie2code.userservice.domain.valueobject;

import com.charlie2code.userservice.domain.exception.InvalidEmailException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public final class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,}$");

    private final String value;

    private Email(String value) {
        if (value == null || value.isBlank() || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidEmailException(value);
        }

        this.value = value.trim().toLowerCase();
    }

    public static Email of(String value) {
        return new Email(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email other)) return false;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
