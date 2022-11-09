package cn.lxh.java.DesignStyle.strategy;

/**
 * ���ģʽ--����ģʽ
 * Created by starlin
 * on 2016/09/09 14:46.
 */
public interface Strategy {
    void algorithm();
}

class ConcreteStrategyA implements  Strategy{

    @Override
    public void algorithm() {
        System.out.println("���ò���A����");
    }
}

class ConcreteStrategyB implements Strategy{

    @Override
    public void algorithm() {
        System.out.println("���ò���B����");
    }
}

class ConcreteStrategyC implements Strategy{

    public void algorithm() {
        System.out.println("���ò���C����");
    }

}