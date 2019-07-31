package cn.lxh.java.DesignStyle.strategy;

/**
 * Created by starlin
 * on 2016/09/09 14:50.
 * method方法是上下文类的一个公开方法，实际当中一般会和业务相关，这里就暂且取名为method方法。下面我们使用客户端调用一下
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.method();

        context.setStrategy(new ConcreteStrategyB());
        context.method();

        context.setStrategy(new ConcreteStrategyC());
        context.method();
    }
}
