package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:07.
 * 定义饮料的抽象基类
 */
public abstract class Beverage {
    //返回描述
    public abstract String getDescription();
    //返回价格
    public abstract double cost();
}
