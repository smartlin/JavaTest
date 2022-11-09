package cn.lxh.java.DesignStyle.factory;

/**
 * Created by starlin
 * on 2016/08/22 16:16.
 */
public class RedCreator implements Creator {
    @Override
    public Light createLight() {
        return new RedLight();
    }
}
