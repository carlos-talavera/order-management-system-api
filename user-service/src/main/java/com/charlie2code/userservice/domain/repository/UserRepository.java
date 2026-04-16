package com.charlie2code.userservice.domain.repository;

import com.charlie2code.userservice.domain.entity.User;

public interface UserRepository {
    User save(User user);
}
