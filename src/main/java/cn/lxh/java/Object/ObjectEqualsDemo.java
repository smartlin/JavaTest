package cn.lxh.java.Object;

import java.util.Objects;

/**
 * Created by starlin
 * on 2022/3/24 18:56.
 * 在使用Objects.equals方法，判断两个值是否相等时，一定要保证两个入参的类型要一致。
 * 否则即使两个值相同，但其结果仍然会返回false，这是一个大坑。
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
