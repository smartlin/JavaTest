package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:10.
 * ����������ϣ����
 */
public class GreenTea extends Beverage {
    @Override
    public String getDescription() {
        return "�̲�";
    }

    @Override
    public double cost() {
        return 11;
    }
}
