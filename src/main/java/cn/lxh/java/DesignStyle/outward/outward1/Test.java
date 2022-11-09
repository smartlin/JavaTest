package cn.lxh.java.DesignStyle.outward.outward1;

/**
 * Created by starlin
 * on 2018/3/18 21:40.
 * 外观模式的优点显而易见，客户端不再需要关注实例化时应该使用哪个实现类，
 * 直接调用门面提供的方法就可以了，因为门面类提供的方法的方法名对于客户端来说已经很友好了
 */
public class Test {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }
}
