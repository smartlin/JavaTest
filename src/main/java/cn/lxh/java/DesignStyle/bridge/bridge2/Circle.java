package cn.lxh.java.DesignStyle.bridge.bridge2;

/**
 * Created by starlin
 * on 2018/3/18 21:56.
 */
public class Circle extends Shape {

    protected Circle(DrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    public void draw() {
        drawAPI.draw();
    }
}
