package cn.lxh.java.DesignStyle.factory;

/**
 * Created by starlin
 * on 2016/08/22 16:15.
 * 创建指定产品的具体工厂
 */
public class BlueCreator implements Creator{
    @Override
    public Light createLight() {
        return new BlueLight();
    }
}
