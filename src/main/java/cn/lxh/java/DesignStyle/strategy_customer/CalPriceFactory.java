package cn.lxh.java.DesignStyle.strategy_customer;

/**
 * Created by starlin
 * on 2016/09/09 15:34.
 * 使用一个标准的简单工厂来改进一下策略模式
 */
public class CalPriceFactory {
    public static CalPrice createCalPrice(Customer customer){
        if(customer.getTotalAmount() > 3000){
            return new GoldVip();
        }else if(customer.getTotalAmount() > 2000){
            return new SuperVip();
        }else if(customer.getTotalAmount() > 1000){
            return new Vip();
        }else{
            return new Common();
        }
    }
}
