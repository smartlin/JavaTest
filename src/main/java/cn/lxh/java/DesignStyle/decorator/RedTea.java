package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:09.
 * 定义基础饮料：红茶
 */
public class RedTea extends Beverage {

    @Override
    public String getDescription() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 10;
    }
}
