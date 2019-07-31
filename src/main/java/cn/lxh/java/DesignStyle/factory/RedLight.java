package cn.lxh.java.DesignStyle.factory;

/**
 * Created by starlin
 * on 2016/08/22 16:11.
 * 具体的产品
 */
public class RedLight implements Light{
    @Override
    public void turnOn() {
        System.out.println("RedLight turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("RedLight turnOff");
    }
}
