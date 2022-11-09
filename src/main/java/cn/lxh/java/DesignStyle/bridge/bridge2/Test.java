package cn.lxh.java.DesignStyle.bridge.bridge2;

/**
 * Created by starlin
 * on 2018/3/18 21:58.
 */
public class Test {
    public static void main(String[] args) {
        Shape blueshape = new Circle(new BluePen());
        blueshape.draw();

        Shape redshape = new Rectangle(new RedPen());
        redshape.draw();
    }
}
