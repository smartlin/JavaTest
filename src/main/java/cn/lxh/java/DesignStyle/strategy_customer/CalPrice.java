package cn.lxh.java.DesignStyle.strategy_customer;

/**
 * Created by starlin
 * on 2016/09/09 15:01.
 * 举例就采用最简单的，以上四种顾客分别采用原价，八折，七折和半价的收钱方式
 */
public interface CalPrice {
    //根据原价返回一个最终的价格
    public Double calPrice(Double originalPrice);
}

//四中计算方式，分别是原价，八折，七折和半价
class Common implements CalPrice{

    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}

class Vip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
class SuperVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }

}
class GoldVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }

}