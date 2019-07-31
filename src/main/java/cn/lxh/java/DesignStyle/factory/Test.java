package cn.lxh.java.DesignStyle.factory;

/**
 * Created by starlin
 * on 2016/08/22 16:16.
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        Creator creator =  new BlueCreator();
        Light light = creator.createLight();
        light.turnOff();
        light.turnOn();

        creator =  new RedCreator();
        light = creator.createLight();
        light.turnOn();
        light.turnOff();
    }
}
