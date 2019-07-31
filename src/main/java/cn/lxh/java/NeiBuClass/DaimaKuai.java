package cn.lxh.java.NeiBuClass;

/**
 * 执行顺序：静态代码块 > 构造代码块 > 构造方法
 * Created by starlin
 * on 2015/10/22 14:38.
 */
class DaimaKuaiTest{
    public DaimaKuaiTest(){//构造方法
        System.out.println("d");
    }
    static {//静态代码块
        System.out.println("a");
    }
    {//构造代码块
        System.out.println("b");
    }
}
public class DaimaKuai {
    public static void main(String[] args) {
        DaimaKuaiTest d = new DaimaKuaiTest();
        System.out.println("c");
    }
}
