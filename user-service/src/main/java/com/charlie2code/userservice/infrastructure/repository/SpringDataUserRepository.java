package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.infrastructure.entity.UserRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserRow, Long> {
    Optional<UserRow> findByAuthId(UUID authId);
}
