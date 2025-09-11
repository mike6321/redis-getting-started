package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RedisTemplate<String, User> userRedisTemplate;
    private final RedisTemplate<String, Object> objectRedisTemplate;

//    public User getUserV1(Long id) {
//        // 1. cache get
//        String userKey = "users:%d".formatted(id);
//        User cachedUser = this.userRedisTemplate.opsForValue().get(userKey);
//        if (!Objects.isNull(cachedUser)) {
//            return cachedUser;
//        }
//
//        // 2. db get
//        User user = this.userRepository.findById(id).orElseThrow();
//        this.userRedisTemplate.opsForValue().set(userKey, user, Duration.ofSeconds(30));
//
//        return user;
//    }

    public User getUserV2(Long id) {
        // 1. cache get
        String userKey = "users:%d".formatted(id);
        var cachedUser = this.objectRedisTemplate.opsForValue().get(userKey);
        if (!Objects.isNull(cachedUser)) {
            return (User) cachedUser;
        }

        // 2. db get
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRedisTemplate.opsForValue().set(userKey, user, Duration.ofSeconds(30));

        return user;
    }

}
