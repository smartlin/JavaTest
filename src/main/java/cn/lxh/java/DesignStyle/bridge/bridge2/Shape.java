package cn.lxh.java.DesignStyle.bridge.bridge2;

/**
 * Created by starlin
 * on 2018/3/18 21:54.
 * ����һ��������
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
