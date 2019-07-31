package cn.lxh.java.DesignStyle.strategy;

/**
 * 下面是我们的上下文，它会拥有一个策略接口
 * Created by starlin
 * on 2016/09/09 14:49.
 */
public class Context {
    private Strategy strategy;
    public void method(){
        strategy.algorithm();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
