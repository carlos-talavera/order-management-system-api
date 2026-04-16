package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.infrastructure.entity.UserRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserRow, Long> {
    @Query(value = """
        INSERT INTO users (id, auth_id, first_name, last_name, email, created_at, updated_at)
        VALUES (:id, :authId, :firstName, :lastName, :email, :createdAt, :updatedAt)
        ON CONFLICT (auth_id)
        DO UPDATE SET
            updated_at = EXCLUDED.updated_at
        RETURNING id, auth_id, first_name, last_name, email, created_at, updated_at
    """, nativeQuery = true)
    UserRow upsert(
            @Param("id") UUID id,
            @Param("authId") UUID authId,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("createdAt") Instant createdAt,
            @Param("updatedAt") Instant updatedAt
    );
}
