package com.charlie2code.userservice.presentation.http.controller;

import com.charlie2code.userservice.application.command.createuser.CreateUserCommand;
import com.charlie2code.userservice.application.dto.createuser.CreateUserRequest;
import com.charlie2code.userservice.application.dto.createuser.CreateUserResult;
import com.charlie2code.userservice.application.mapper.createuser.CreateUserMapper;
import com.charlie2code.userservice.application.usecase.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResult> create(@RequestBody @Valid CreateUserRequest request) {
        CreateUserCommand command = CreateUserMapper.toCommand(request);
        UUID userId = createUserUseCase.execute(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateUserResult(userId.toString()));
    }
}
