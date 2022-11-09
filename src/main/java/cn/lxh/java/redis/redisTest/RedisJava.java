package cn.lxh.java.redis.redisTest;

import redis.clients.jedis.Jedis;

/**
 * Created by starlin
 * on 2017/08/29 11:35.
 */
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.128.132",6379);
        jedis.auth("starlin");
        System.out.println(jedis.ping());
    }
}
