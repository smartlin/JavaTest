package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:10.
 * 定义基础饮料：红茶
 */
public class GreenTea extends Beverage {
    @Override
    public String getDescription() {
        return "绿茶";
    }

    @Override
    public double cost() {
        return 11;
    }
}
