package com.charlie2code.userservice.application.usecase;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.mapper.createuser.CreateUserMapper;
import com.charlie2code.userservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;

    @Transactional
    public UUID execute(CreateUserCommand command) {
        return userRepository.save(CreateUserMapper.toDomain(command)).getId().getValue();
    }
}
