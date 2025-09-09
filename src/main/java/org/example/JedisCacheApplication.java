package org.example;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JedisCacheApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JedisCacheApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.userRepository.save(
                User.builder()
                        .name("junwoo")
                        .email("junwoo@test.com")
                        .build()
        );

        this.userRepository.save(
                User.builder()
                        .name("junwoo1")
                        .email("junwoo1@test.com")
                        .build()
        );

        this.userRepository.save(
                User.builder()
                        .name("junwoo2")
                        .email("junwoo2@test.com")
                        .build()
        );

        this.userRepository.save(
                User.builder()
                        .name("junwoo3")
                        .email("junwoo3@test.com")
                        .build()
        );
    }

}
