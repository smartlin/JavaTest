package cn.lxh.java.DesignStyle.Proxy;

/**
 * Created by starlin
 * on 2018/3/17 22:51.
 * RealSubject�ඨ��Proxy���������ʵʵ��
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("��ʵ������");
    }
}
