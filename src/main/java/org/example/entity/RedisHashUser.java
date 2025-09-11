package org.example.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@RedisHash(value = "redis-hash-user", timeToLive = 30L)
public class RedisHashUser {

    @Id
    private Long id;

    @Indexed
    private String email;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
