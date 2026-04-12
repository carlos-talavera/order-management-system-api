package com.charlie2code.userservice.infrastructure.mapper;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.valueobject.Email;
import com.charlie2code.userservice.domain.valueobject.UserId;
import com.charlie2code.userservice.infrastructure.entity.UserRow;

public class UserMapper {

    private UserMapper() {}

    public static UserRow toRow(User user) {
        UserRow row = new UserRow();

        row.setId(user.getId().getValue());
        row.setAuthId(user.getAuthId());
        row.setFirstName(user.getFirstName());
        row.setLastName(user.getLastName());
        row.setEmail(user.getEmail().getValue());
        row.setCreatedAt(user.getCreatedAt());
        row.setUpdatedAt(user.getUpdatedAt());

        return row;
    }

    public static User toDomain(UserRow row) {
        return User.create(
            UserId.of(row.getId()),
            row.getAuthId(),
            Email.of(row.getEmail()),
            row.getFirstName(),
            row.getLastName()
        );
    }
}
