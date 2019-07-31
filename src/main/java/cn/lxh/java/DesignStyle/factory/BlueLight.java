package cn.lxh.java.DesignStyle.factory;

/**
 * Created by starlin
 * on 2016/08/22 16:10.
 * 具体的产品
 */
public class BlueLight implements Light{
    @Override
    public void turnOn() {
        System.out.println("BlueLight turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("BlueLight turnOff");
    }
}
