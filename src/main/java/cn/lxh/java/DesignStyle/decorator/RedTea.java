package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:09.
 * ����������ϣ����
 */
public class RedTea extends Beverage {

    @Override
    public String getDescription() {
        return "���";
    }

    @Override
    public double cost() {
        return 10;
    }
}
