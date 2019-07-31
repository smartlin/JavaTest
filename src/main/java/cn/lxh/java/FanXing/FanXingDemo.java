package cn.lxh.java.FanXing;

/**
 * T为泛型的标识，可以定义为Integer，String，Double等
 * 静态方法不可以访问类上定义的泛型
 * Created by starlin
 * on 2015/09/20 16:28.
 */
class FanXing<T>{
    private T x;
    private T y;

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "FanXing{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class FanXingDemo {
    public static void main(String[] args) {
        FanXing<Integer> f = new FanXing<Integer>();
        f.setX(20);
        f.setY(30);
        System.out.println(f.toString());
    }
}
