package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.resps.Tuple;

import java.util.HashMap;
import java.util.List;

public class RedisSortedSet {

    private static String KEY = "game2:scores";
    
    public static void main(String[] args) {
        try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (Jedis jedis = jedisPool.getResource()) {
                // zadd
                // zadd(jedis);

                // zrange
                // jedis.zrange(KEY, 0, Long.MAX_VALUE).forEach(System.out::println);

                // zrandmemberWithScores
                // zrandmemberWithScores(jedis);

                // zcard
                // zcard(jedis);
            }
        }
    }

    private static void zcard(Jedis jedis) {
        System.out.println(jedis.zcard(KEY));
    }

    private static void zrandmemberWithScores(Jedis jedis) {
        List<Tuple> scores = jedis.zrandmemberWithScores(KEY, 10);
        scores.forEach(System.out::println);
    }

    private static void zadd(Jedis jedis) {
        var scores = new HashMap<String, Double>();
        scores.put("user1:scores", 100.0);
        scores.put("user2:scores", 30.0);
        scores.put("user3:scores", 40.0);
        scores.put("user4:scores", 125.0);

        jedis.zadd(KEY, scores);
    }

}
