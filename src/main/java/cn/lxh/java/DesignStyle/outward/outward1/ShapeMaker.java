package cn.lxh.java.DesignStyle.outward.outward1;

/**
 * Created by starlin
 * on 2018/3/18 21:37.
 * 定义一个外观
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
