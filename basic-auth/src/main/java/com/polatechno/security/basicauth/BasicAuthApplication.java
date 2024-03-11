package com.polatechno.security.basicauth;

import com.polatechno.security.basicauth.dto.CreateUserRequest;
import com.polatechno.security.basicauth.model.Role;
import com.polatechno.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

    private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData() {

        CreateUserRequest user1Admin = CreateUserRequest.builder()
                .name("Aganyyaz")
                .username("admin")
                .password("Test123")
                .authorities(Set.of(Role.ROLE_ADMIN, Role.ROLE_POLATECHNO))
                .build();
        userService.createUser(user1Admin);

        CreateUserRequest userModerator = CreateUserRequest.builder()
                .name("Aman")
                .username("aman")
                .password("Test123")
                .authorities(Set.of(Role.ROLE_MODERATOR, Role.ROLE_USER))
                .build();
        userService.createUser(userModerator);

        CreateUserRequest request = CreateUserRequest.builder()
                .name("Polat")
                .username("polatechno")
                .password("Test123")
                .authorities(Set.of(Role.ROLE_POLATECHNO))
                .build();
        userService.createUser(request);

    }
}
