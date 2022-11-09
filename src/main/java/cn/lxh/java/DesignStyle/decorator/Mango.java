package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:16.
 */
public class Mango extends Condiment {

    private Beverage beverage;

    public Mango(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        // װ��
        return beverage.getDescription() + "��â��";
    }

    @Override
    public double cost() {
        // װ�� ��â����3Ԫ
        return beverage.cost() + 3;
    }
}
