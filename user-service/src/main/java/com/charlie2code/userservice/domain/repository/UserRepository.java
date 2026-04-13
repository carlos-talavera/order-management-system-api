package com.charlie2code.userservice.domain.repository;

import com.charlie2code.userservice.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findByAuthId(UUID authId);
    User save(User user);
}
