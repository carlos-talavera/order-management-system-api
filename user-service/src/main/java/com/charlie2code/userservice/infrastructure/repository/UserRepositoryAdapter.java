package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.repository.UserRepository;
import com.charlie2code.userservice.infrastructure.entity.UserRow;
import com.charlie2code.userservice.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository repository;

    public UserRepositoryAdapter(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User insertIfNotExists(User user) {
        UserRow row = UserMapper.toRow(user);

        return repository.insertIfNotExists(
            row.getId(),
            row.getAuthId(),
            row.getFirstName(),
            row.getLastName(),
            row.getEmail(),
            row.getCreatedAt(),
            row.getUpdatedAt()
        )
            .map(UserMapper::toDomain)
            .orElseGet(() ->
                repository.findByAuthId(row.getAuthId())
                    .map(UserMapper::toDomain)
                    .orElseThrow(() ->
                            new IllegalStateException(
                                    "Insert failed and user not found for authId=" + row.getAuthId()
                            )
                    )
            );
    }
}
