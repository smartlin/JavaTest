package cn.lxh.java.DesignStyle.Proxy;

/**
 * Created by starlin
 * on 2018/3/17 22:53.
 */
public class Proxy extends Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
