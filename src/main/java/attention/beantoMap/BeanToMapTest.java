package attention.beantoMap;

import cn.lxh.java.redis.springRedis.User;
import lombok.extern.slf4j.Slf4j;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by starlin
 * on 2022/9/1 18:16.
 * 反射的方式JavaBean to Map
 * Java Bean 转 Map 的坑很多，最常见的就是类型丢失和属性名解析错误的问题
 */
@Slf4j
public class BeanToMapTest {
    public static void main(String[] args) throws Exception {
        User user = new User("starlin","starlin123");
        user.setPassWord("starlin");
        Map<String, Object> map = BeanToMapTest.beanToMap(user, User.class);
        System.out.println(map);
    }

    /**
     * 利用反射将java bean转换为map
     * @param bean
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object bean, Class clazz) throws Exception {
        Map<String, Object> wrapper = new HashMap<>(16);
        if (bean == null) {
            return wrapper;
        }
        for (PropertyDescriptor pd : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
            Object value = pd.getReadMethod().invoke(bean);
            wrapper.put(pd.getName(), value);
        }
        return wrapper;
    }

}
