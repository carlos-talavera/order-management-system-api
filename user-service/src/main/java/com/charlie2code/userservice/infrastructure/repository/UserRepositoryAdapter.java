package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.repository.UserRepository;
import com.charlie2code.userservice.infrastructure.entity.UserRow;
import com.charlie2code.userservice.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository repository;

    public UserRepositoryAdapter(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findByAuthId(UUID authId) {
        return repository.findByAuthId(authId).map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserRow userRow = UserMapper.toRow(user);
        UserRow savedRow = repository.save(userRow);

        return UserMapper.toDomain(savedRow);
    }
}
