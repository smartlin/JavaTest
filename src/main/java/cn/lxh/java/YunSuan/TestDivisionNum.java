package cn.lxh.java.YunSuan;

/**
 * Created by starlin
 * on 2022/8/31 11:34.
 * ��ĸΪ0�ĳ���
 * 1.�ڸ�����/0��ʱ��
 * that's the way it's specified in the IEEE-754 standard,
 * which is what Java's Floating-Point Operations are based on.
 */
public class TestDivisionNum {
    public static void main(String[] args) {
        //���ΪInfinity������ģ�IEEE-754 standard ��
        System.out.println(6.2/0);
        //���Ϊjava.lang.ArithmeticException: / by zero
        System.out.println(6/0);
    }
}
