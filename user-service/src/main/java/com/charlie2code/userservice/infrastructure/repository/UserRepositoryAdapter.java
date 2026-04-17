package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.repository.UserRepository;
import com.charlie2code.userservice.infrastructure.entity.UserRow;
import com.charlie2code.userservice.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository repository;

    @Override
    public User save(User user) {
        UserRow row = UserMapper.toRow(user);

        UserRow result = repository.upsert(
            row.getId(),
            row.getAuthId(),
            row.getFirstName(),
            row.getLastName(),
            row.getEmail(),
            row.getCreatedAt(),
            row.getUpdatedAt()
        );

        return UserMapper.toDomain(result);
    }
}
