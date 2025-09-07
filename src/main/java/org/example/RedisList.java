package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisList {

    public static void main(String[] args) {
        try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);) {
            try (Jedis jedis = jedisPool.getResource()) {
                // stack
                // stack(jedis);

                // queue
                // queue(jedis);

                // block brpop blpop
                // brpop(jedis);
            }
        }
    }

    private static void brpop(Jedis jedis) {
        List<String> blpop = jedis.blpop(10, "b:queue");
        if (blpop != null) {
            blpop.forEach(System.out::println);
        }
    }

    private static void queue(Jedis jedis) {
        jedis.rpush("queue", "1");
        jedis.rpush("queue", "2");
        jedis.rpush("queue", "3");

        System.out.println(jedis.lpop("queue"));
        System.out.println(jedis.lpop("queue"));
        System.out.println(jedis.lpop("queue"));
    }

    private static void stack(Jedis jedis) {
        jedis.rpush("stack", "1");
        jedis.rpush("stack", "2");
        jedis.rpush("stack", "3");


        System.out.println("*******************");
        System.out.println(jedis.rpop("stack"));
        System.out.println(jedis.rpop("stack"));
        System.out.println(jedis.rpop("stack"));

        List<String> stack = jedis.lrange("stack", 0, -1);
        stack.forEach(System.out::println);
    }

}
