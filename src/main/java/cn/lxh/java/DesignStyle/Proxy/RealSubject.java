package cn.lxh.java.DesignStyle.Proxy;

/**
 * Created by starlin
 * on 2018/3/17 22:51.
 * RealSubject类定义Proxy所代表的真实实体
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
