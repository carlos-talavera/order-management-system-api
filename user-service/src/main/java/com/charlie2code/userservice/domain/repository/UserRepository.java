package com.charlie2code.userservice.domain.repository;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.valueobject.Email;

public interface UserRepository {
    Boolean existsByEmail(Email email);
    User save(User user);
}
