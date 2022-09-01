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
 * ����ķ�ʽJavaBean to Map
 * Java Bean ת Map �ĿӺܶ࣬����ľ������Ͷ�ʧ���������������������
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
     * ���÷��佫java beanת��Ϊmap
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
