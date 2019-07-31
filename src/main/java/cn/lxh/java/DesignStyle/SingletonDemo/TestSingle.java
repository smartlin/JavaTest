package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * Created by starlin
 * on 2016/08/22 9:39.
 * 单利模式的另外一种写法，一开始不初始化TestSingle的实例，避免了内存的浪费
 */
public class TestSingle {
    private TestSingle(){

    }
    private static class TestSingleInstance{
        static TestSingle instance = new TestSingle();
    }
    public static TestSingle getInstance(){
        return TestSingleInstance.instance;
    }

    public static void main(String[] args) {
        TestSingle t1 = TestSingle.getInstance();
        TestSingle t2 = TestSingle.getInstance();
        System.out.println(t1==t2);
    }
}


