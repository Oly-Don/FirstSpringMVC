package com.set.tools;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;


/*

redis 连接操作

 */
public class RedisTest {

    @Test
    public void testRedisConnect() {
        Jedis jedis = new Jedis("192.168.0.183", 6379);
        System.out.println("redis 连接成功");
        String myName = "myName";
        jedis.set(myName, "it form outter space");
        System.out.println(jedis.get(myName));
        jedis.lpush("language", "java");
        jedis.lpush("language", "php");
        jedis.lpush("language", "python");
        List<String> lrange = jedis.lrange("language", 0, 4);
        System.out.println(lrange);

        jedis.mset("key", "values");
        jedis.mset("jendis", "redis");
        String set = jedis.getSet("key", "333");
        String unexist = jedis.getSet("key2", "231");
        System.out.println(set + "\n" + unexist + "\n" + jedis.get("key2"));
        Set<String> keys = jedis.keys("*");
        for (String key :
                keys) {
//            System.out.println(jedis.get(key));
        }
    }
}
