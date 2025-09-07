package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisSet {

    public static void main(String[] args) {
        try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);) {
            try (Jedis jedis = jedisPool.getResource()) {
                // sadd
                //sadd(jedis);

                // srem
                //srem(jedis);

                // smemebers
                // smembers(jedis);

                // sismember
                // sismember(jedis);

                // scard
                // scard(jedis);


                // sinter
                // sinter(jedis);
            }
        }
    }

    private static void sinter(Jedis jedis) {
        jedis.sadd("user:100:follow", "100", "200", "300");
        jedis.sadd("user:200:follow", "300", "400", "500");
        jedis.sinter("user:100:follow", "user:200:follow").forEach(System.out::println);
    }

    private static void scard(Jedis jedis) {
        long result = jedis.scard("user:100:follow");
        System.out.println(result);
    }

    private static void sismember(Jedis jedis) {
        boolean result = jedis.sismember("user:100:follow", "30");
        System.out.println(result);
    }

    private static void smembers(Jedis jedis) {
        jedis.smembers("user:100:follow").forEach(System.out::println);
    }

    private static void srem(Jedis jedis) {
        jedis.srem("user:100:follow", "10");
    }

    private static void sadd(Jedis jedis) {
        jedis.sadd("user:100:follow", "10", "20", "30");
    }

}
