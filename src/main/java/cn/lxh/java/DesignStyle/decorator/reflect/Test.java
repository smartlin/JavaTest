package cn.lxh.java.DesignStyle.decorator.reflect;

/**
 * Created by starlin
 * on 2019/9/21 16:17.
 */
public class Test {
    public static void main(String[] args) {
        Animal jerry = new Rat();
        //为jerry增加飞行能力
        jerry = new DecoratorAnimal(jerry, FlyFeature.class);
        //为jerry增加钻地能力
        jerry = new DecoratorAnimal(jerry, DigFeature.class);
        jerry.duStuff();
    }
}
