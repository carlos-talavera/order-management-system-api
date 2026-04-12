package com.charlie2code.userservice.infrastructure.repository;

import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.repository.UserRepository;
import com.charlie2code.userservice.domain.valueobject.Email;
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
    public Boolean existsByEmail(Email email) {
        return repository.existsByEmail(email.getValue());
    }

    @Override
    public User save(User user) {
        UserRow userRow = UserMapper.toRow(user);
        UserRow savedRow = repository.save(userRow);

        return UserMapper.toDomain(savedRow);
    }
}
