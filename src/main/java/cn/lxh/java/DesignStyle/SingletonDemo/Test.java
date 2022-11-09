package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * Created by starlin
 * on 2016/09/27 9:37.
 */
public class Test {

  /*  private FutureTest(){}
    private static class testSingle{
        static FutureTest INSTANCE = new FutureTest();
    }
    public static FutureTest getInstance(){
        return testSingle.INSTANCE;
    }*/

    private Test(){}
    private static final Test INSTANCE = new Test();
    public static Test getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Test test1 = Test.getInstance();
        Test test2 = Test.getInstance();
        System.out.println(test1.equals(test2));
    }
}
