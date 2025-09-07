package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class RedisHash {

    public static void main(String[] args) {
        try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);) {
            try (Jedis jedis = jedisPool.getResource()) {
                // hset
                // hset(jedis);

                // hget
                // hget(jedis);

                // hdel
                // hdel(jedis);

                // hincrBy
                // hincrBy(jedis);

                // hgetAll
                hgetAll(jedis);
            }
        }
    }

    private static void hincrBy(Jedis jedis) {
        jedis.hincrBy("users:100:info", "visits", 10);
        jedis.hincrBy("users:100:info", "visits", 10);
        jedis.hincrBy("users:100:info", "visits", 10);
        jedis.hincrBy("users:100:info", "visits", 10);
    }

    private static void hdel(Jedis jedis) {
        jedis.hdel("users:100:info", "name");
    }

    private static void hget(Jedis jedis) {
        String name = jedis.hget("users:100:info", "name");
        System.out.println("name = " + name);
    }

    private static void hgetAll(Jedis jedis) {
        jedis.hgetAll("users:100:info").forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void hset(Jedis jedis) {
        Map<String, String> userInfo = Map.of("name", "junwoo", "age", "25");
        jedis.hset("users:100:info", userInfo);
    }

}
