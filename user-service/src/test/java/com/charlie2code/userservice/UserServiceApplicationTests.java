package com.charlie2code.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
@SpringBootTest
class UserServiceApplicationTests {

    @Container
    public static ComposeContainer environment =
            new ComposeContainer(new File("compose.yaml"))
                    .withExposedService("postgres", 5432);

    @Test
    void contextLoads() {}
}