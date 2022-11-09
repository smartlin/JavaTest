package cn.lxh.java.YunSuan;

/**
 * Created by starlin
 * on 2022/8/31 11:34.
 * 分母为0的除法
 * 1.在浮点数/0的时候，
 * that's the way it's specified in the IEEE-754 standard,
 * which is what Java's Floating-Point Operations are based on.
 */
public class TestDivisionNum {
    public static void main(String[] args) {
        //结果为Infinity（无穷的，IEEE-754 standard ）
        System.out.println(6.2/0);
        //结果为java.lang.ArithmeticException: / by zero
        System.out.println(6/0);
    }
}
