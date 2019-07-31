package cn.lxh.java.redis.springRedis;

/**
 * Created by starlin
 * on 2017/08/30 22:41.
 */
public interface UserDao {
    boolean add(User user);

    boolean del(String key);

    boolean update(User user);

    Object get(String key);
}

