package cn.lxh.java.DesignStyle.decorator.reflect;

/**
 * Created by starlin
 * on 2019/9/21 16:03.
 * 利用反射实现的装饰器模式
 */
public interface Feature {
    //定义某种能力
    public void load();
}

class FlyFeature implements Feature {

    // 定义会飞的能力
    @Override
    public void load() {
        System.out.println("增加一双翅膀");
    }
}

class DigFeature implements Feature {

    //定义钻地能力
    @Override
    public void load() {
        System.out.println("增加钻地能力");
    }
}
