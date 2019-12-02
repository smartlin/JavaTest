package cn.lxh.java.DesignStyle.decorator.reflect;

/**
 * Created by starlin
 * on 2019/9/21 16:17.
 */
public class Test {
    public static void main(String[] args) {
        Animal jerry = new Rat();
        //Ϊjerry���ӷ�������
        jerry = new DecoratorAnimal(jerry, FlyFeature.class);
        //Ϊjerry�����������
        jerry = new DecoratorAnimal(jerry, DigFeature.class);
        jerry.duStuff();
    }
}
