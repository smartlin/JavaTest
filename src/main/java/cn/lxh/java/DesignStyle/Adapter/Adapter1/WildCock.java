package cn.lxh.java.DesignStyle.Adapter.Adapter1;

/**
 * Created by starlin
 * on 2018/3/18 19:02.
 */
public class WildCock implements Cock{
    @Override
    public void gobble() {
        System.out.println("������");
    }

    @Override
    public void fly() {
        System.out.println("��Ҳ���");
    }
}
