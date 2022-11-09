package cn.lxh.java.DesignStyle.Adapter.Adapter1;

/**
 * Created by starlin
 * on 2018/3/18 19:04.
 * 鸭接口有 fly() 和 quare() 两个方法，鸡 Cock 如果要冒充鸭，fly() 方法是现成的，
 * 但是鸡不会鸭的呱呱叫，没有 quack() 方法。这个时候就需要适配了：
 */
public class CockAdapter implements Duck {

    Cock cock;

    // 构造方法中需要一个鸡的实例，此类就是将这只鸡适配成鸭来用
    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    // 实现鸭的呱呱叫方法
    @Override
    public void quack() {
        cock.gobble();
    }

    @Override
    public void fly() {
        cock.fly();
    }
}
