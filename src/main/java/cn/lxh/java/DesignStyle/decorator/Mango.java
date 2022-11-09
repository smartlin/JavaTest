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
        // 装饰
        return beverage.getDescription() + "加芒果";
    }

    @Override
    public double cost() {
        // 装饰 加芒果加3元
        return beverage.cost() + 3;
    }
}
