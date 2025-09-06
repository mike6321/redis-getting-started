package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.List;
import java.util.logging.Logger;

public class RedisStrings {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(RedisStrings.class.getName());

        try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);) {
            try(Jedis jedis = jedisPool.getResource()) {
                // set
                jedis.set("foo", "bar");
                jedis.set("email", "test@test.com");
                jedis.set("age", "25");

                // get
                String getResult = jedis.get("foo");
                logger.info("getResult = " + getResult);

                // mget
                List<String> mgetResult = jedis.mget("foo", "email", "age");
                logger.info("mgetResult = " + mgetResult);

                // incr
                long incrResult = jedis.incr("counter");
                logger.info("incrResult = " + incrResult);

                incrResult = jedis.incrBy("counter", 10);
                logger.info("incrByResult = " + incrResult);

                // decr
                incrResult = jedis.decr("counter");
                logger.info("decrResult = " + incrResult);

                incrResult = jedis.decrBy("counter", 10);
                logger.info("decrByResult = " + incrResult);

                Pipeline pipelined = jedis.pipelined();
                pipelined.set("foo", "bar1");
                pipelined.set("foo", "bar2");
                pipelined.set("foo", "bar3");
                pipelined.set("foo", "bar4");
                List<Object> result = pipelined.syncAndReturnAll();
                result.forEach(obj -> logger.info("result = " + obj));
            }
        }
    }

}
