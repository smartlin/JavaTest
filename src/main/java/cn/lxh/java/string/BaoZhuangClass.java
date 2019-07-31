package cn.lxh.java.string;

/**
 * 包装类
 * 基本数据类型、包装类------->可以转换为String，方法是Integer.toString(Integer对象)
 * String类转换为--->基本数据类型、包装类:调用包装类的parseXX（）
 * Created by starlin
 * on 2015/10/18 20:41.
 */
public class BaoZhuangClass {
    public static void main(String[] args) {
        Integer i = 10;//自动装箱，10默认就是 new Integer(10),直接把i参与运算就是自动拆箱
        String s1 = i.toString(i);//将包装类转换为字符串
        System.out.println(s1);
        System.out.println(Integer.parseInt(s1));//将字符串转换为包装类parseXX()
    }
}
