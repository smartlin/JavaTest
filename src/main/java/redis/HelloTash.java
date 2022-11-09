package redis;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 利用Redis简单实现分布式锁
 * Created by starlin
 * on 2018/8/12 16:56.
 */
public class HelloTash {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String KEY = "lock_hello";

    public void doTask() {
        boolean lock = false;
        try{
            //获取锁，程序中调用setIfAbsent方法来获取锁，如果返回true，则说明key不存在，表示获取到了锁
            //若返回false，说明key存在，已经有程序在使用这个key了
            lock = stringRedisTemplate.opsForValue().setIfAbsent("lock_hello","1");
            if (!lock) {
                //获取不到锁，直接退出
                return;
            }
            stringRedisTemplate.expire(KEY, 5, TimeUnit.MINUTES);
            //to do something
            System.out.println("");
        }finally {
            //最终释放锁
            stringRedisTemplate.delete(KEY);
        }
    }
}
