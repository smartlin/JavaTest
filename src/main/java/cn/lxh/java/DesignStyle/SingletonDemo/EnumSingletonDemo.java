package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * Created by starlin
 * on 2019/8/13 16:04.
 * 通过EnumSingletonDemo.INSTANCE.getInstance(); 获取资源
 */

class EnumSingleton{
}


public enum EnumSingletonDemo {
    INSTANCE,
    ;
    private EnumSingleton instance;
    private EnumSingletonDemo() {
        instance = new EnumSingleton();
    }

    public EnumSingleton getInstance() {
        return instance;
    }

}

