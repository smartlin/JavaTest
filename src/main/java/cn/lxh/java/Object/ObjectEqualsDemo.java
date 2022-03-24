package cn.lxh.java.Object;

import java.util.Objects;

/**
 * Created by starlin
 * on 2022/3/24 18:56.
 * ��ʹ��Objects.equals�������ж�����ֵ�Ƿ����ʱ��һ��Ҫ��֤������ε�����Ҫһ�¡�
 * ����ʹ����ֵ��ͬ����������Ȼ�᷵��false������һ����ӡ�
 */
public class ObjectEqualsDemo {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        long b = 1;
        //false
        System.out.println(Objects.equals(a, b));
        //true
        System.out.println(Objects.equals(a, (int)b));
        //true
        System.out.println(a==b);
        //false
        System.out.println(a.equals(b));
    }
}
