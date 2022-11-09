package cn.lxh.java.DesignStyle.Template;

/**
 * Created by starlin
 * on 2018/3/18 22:13.
 */
public class ConcreteTemplate extends AbstractTemplate {

    @Override
    protected void apply() {
        System.out.println("子类实现抽象方法");
    }

    public void end() {
        System.out.println("我们可以把 method3 当做钩子方法来使用，需要的时候覆写就可以了");
    }
}
