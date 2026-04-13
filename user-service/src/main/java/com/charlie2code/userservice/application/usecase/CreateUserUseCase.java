package com.charlie2code.userservice.application.usecase;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.mapper.createuser.CreateUserMapper;
import com.charlie2code.userservice.domain.entity.User;
import com.charlie2code.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID execute(CreateUserCommand command) {
        User user = CreateUserMapper.toDomain(command);

        Optional<User> existingUser = this.userRepository.findByAuthId(command.getAuthId());

        if (existingUser.isPresent()) {
            return existingUser.get().getId().getValue();
        }

        User savedUser = this.userRepository.save(user);

        return savedUser.getId().getValue();
    }
}
