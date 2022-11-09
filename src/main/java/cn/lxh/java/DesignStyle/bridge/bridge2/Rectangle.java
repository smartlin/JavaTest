package cn.lxh.java.DesignStyle.bridge.bridge2;

/**
 * Created by starlin
 * on 2018/3/18 21:57.
 */
public class Rectangle extends Shape {
    protected Rectangle(DrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    public void draw() {
        drawAPI.draw();
    }
}
