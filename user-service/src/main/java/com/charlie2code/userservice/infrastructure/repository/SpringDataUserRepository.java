package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.infrastructure.entity.UserRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserRow, Long> {
    boolean existsByEmail(String email);
}
