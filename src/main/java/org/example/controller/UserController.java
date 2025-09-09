package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final JedisPool jedisPool;

    @GetMapping("/users/{id}/email")
    public String getUserEmail(@PathVariable Long id) {
        String userEmailKey = "users:%s:email";
        try(Jedis jedis = jedisPool.getResource()) {
            // 1. request to cache
            String userEmail = jedis.get(userEmailKey.formatted(id));
            if (userEmail != null) {
                return userEmail;
            }

            // 2. db 직접 조회
            userEmail = this.userRepository.findById(id).orElse(User.builder().build()).getEmail();

            // 3. cache 저장
            jedis.setex(userEmailKey.formatted(id), 30, userEmail);
            return userEmail;
        }
    }

}
