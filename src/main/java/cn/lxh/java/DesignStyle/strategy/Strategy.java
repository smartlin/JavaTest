package cn.lxh.java.DesignStyle.strategy;

/**
 * 设计模式--策略模式
 * Created by starlin
 * on 2016/09/09 14:46.
 */
public interface Strategy {
    void algorithm();
}

class ConcreteStrategyA implements  Strategy{

    @Override
    public void algorithm() {
        System.out.println("采用策略A计算");
    }
}

class ConcreteStrategyB implements Strategy{

    @Override
    public void algorithm() {
        System.out.println("采用策略B计算");
    }
}

class ConcreteStrategyC implements Strategy{

    public void algorithm() {
        System.out.println("采用策略C计算");
    }

}