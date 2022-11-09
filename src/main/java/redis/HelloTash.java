package redis;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * ����Redis��ʵ�ֲַ�ʽ��
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
            //��ȡ���������е���setIfAbsent��������ȡ�����������true����˵��key�����ڣ���ʾ��ȡ������
            //������false��˵��key���ڣ��Ѿ��г�����ʹ�����key��
            lock = stringRedisTemplate.opsForValue().setIfAbsent("lock_hello","1");
            if (!lock) {
                //��ȡ��������ֱ���˳�
                return;
            }
            stringRedisTemplate.expire(KEY, 5, TimeUnit.MINUTES);
            //to do something
            System.out.println("");
        }finally {
            //�����ͷ���
            stringRedisTemplate.delete(KEY);
        }
    }
}
