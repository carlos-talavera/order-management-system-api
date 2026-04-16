package com.charlie2code.userservice.application.usecase;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.mapper.createuser.CreateUserMapper;
import com.charlie2code.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UUID execute(CreateUserCommand command) {
        return userRepository.save(CreateUserMapper.toDomain(command)).getId().getValue();
    }
}
