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
        //һ���ṩ��3�ֲ���redis�ķ���
        //ʹ��������ķ�ʽ
     /*   redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserName()),
                        redisTemplate.getStringSerializer().serialize(user.getPassWord()));
                return null;
            }
        });*/

        //������StringRdisTemplate������
        //redisTemplate.opsForValue().set(user.getUserName(),user.getPassWord());

        //������StringRdisTemplate������ ͨ���󶨵ķ�ʽ
        BoundValueOperations<String, String> bound = redisTemplate.boundValueOps(user.getUserName());
        bound.set(user.getPassWord());
        //bound.append(user.getPassWord());//׷�ӣ���StringBuilder��appendһ������
        return true;
    }

    @Override
    public boolean del(String key) {
        try {
            redisTemplate.delete(key);
            System.out.println(key + " ɾ���ɹ���");
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
        System.out.println("û�д��û���" + user.getUserName());
        return false;
    }

    @Override
    public Object get(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //return null;
        return  valueOperations.get(key);
    }


}
