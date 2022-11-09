package springRedis;

import cn.lxh.java.redis.springRedis.User;
import cn.lxh.java.redis.springRedis.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
/**
 * Created by starlin
 * on 2017/08/30 23:06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/springRedis/spring-redis.xml")
public class RedisTest{
    @Resource
    private UserDao userDao;

    @Test
    public void redis(){
        //添加
        userDao.add(new User("starlin","123456"));
        //更新
        userDao.update(new User("starlin","qwe"));
        //查询
        System.out.println(userDao.get("starlin"));
        //删除
        //userDao.delete("hgs");
    }
}
