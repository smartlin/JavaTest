package cn.lxh.java.redis.springRedis;

import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by starlin
 * on 2017/08/30 22:43.
 */
@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean add(final User user) {
        //一下提供了3种操作redis的方法
        //使用最基本的方式
     /*   redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserName()),
                        redisTemplate.getStringSerializer().serialize(user.getPassWord()));
                return null;
            }
        });*/

        //利用了StringRdisTemplate的特性
        //redisTemplate.opsForValue().set(user.getUserName(),user.getPassWord());

        //利用了StringRdisTemplate的特性 通过绑定的方式
        BoundValueOperations<String, String> bound = redisTemplate.boundValueOps(user.getUserName());
        bound.set(user.getPassWord());
        //bound.append(user.getPassWord());//追加，和StringBuilder的append一样功能
        return true;
    }

    @Override
    public boolean del(String key) {
        try {
            redisTemplate.delete(key);
            System.out.println(key + " 删除成功。");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        if (ops.get(user.getUserName()) != null) {
            ops.set(user.getUserName(), user.getPassWord());
            return true;
        }
        System.out.println("没有此用户！" + user.getUserName());
        return false;
    }

    @Override
    public Object get(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //return null;
        return  valueOperations.get(key);
    }


}
